package com.tech.operation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tech.entity.Student;
import com.tech.entity.Teacher;
import com.tech.util.HibernateUtil;

public class Operation {
	
	
	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session=sf.openSession();
		
		// for teacher
		Teacher t=new Teacher();
		t.settId("t_001");
		t.settName("Nikam sir");
		t.setSubject("java");
		
		// for student
		Student st=new Student();
		st.setsId(103);
		st.setsName("mahesh");
		st.setAddrs("pune");
		st.setPincode(411014);
		// forrenKey
		st.setTeacher(t);//student have teacher.
		t.setStudent(st);//teacher have student.
		
		session.save(st);
		session.save(t);
		session.beginTransaction().commit();
		
		//get data from student
	    Student stu=session.get(Student.class, 102);
	       System.out.println(stu.getsName());
	       System.out.println(stu.getTeacher().gettName());
	       System.out.println(stu.getTeacher().getSubject());
	       
	       //get data from Teacher
	 Teacher th=session.get(Teacher.class, "t_001");
	     System.out.println(th.gettName());
	     System.out.println(th.getStudent().getsName());
	     System.out.println(th.getStudent().getAddrs());
	       
		
		session.close();
		sf.close();
	}

}
