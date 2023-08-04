package com.tech.operation;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.tech.entity.Employee;
import com.tech.entity.Manager;
import com.tech.util.HibernateUtil;

public class Operation {
	
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session=sf.openSession();
		
		Transaction tx=session.beginTransaction();
		
		Manager m=new Manager();
		m.setM_Id(1);
		m.setM_Name("Madhav sir");
		m.setM_Department("Devlopment");
		
		Manager m1=new Manager();
		m1.setM_Id(2);
		m1.setM_Name("Nilkant sir");
		m1.setM_Department("Accounts & Finance");
		
		Employee emp=new Employee();
		emp.setE_Id(101);
		emp.setE_name("Yogesh");
		emp.setE_Salary(50000.00);
		
		Employee emp1=new Employee();
		emp1.setE_Id(102);
		emp1.setE_name("Mahesh");
		emp1.setE_Salary(60000.00);
		
		List<Manager>mangs=new ArrayList<>();
		mangs.add(m);
		mangs.add(m1);
		
		List<Employee>emps=new ArrayList<>();
		emps.add(emp);
		emps.add(emp1);
		
		m.setEmployee(emps);
	    m1.setEmployee(emps);
	    
	    emp.setManager(mangs);
	    emp1.setManager(mangs);
	    
	    session.save(m);
	    session.save(m1);
	    session.save(emp);
	    session.save(emp1);
//	    session.save(emps);
//	    session.save(mangs);
	    
	    tx.commit();
	    
	   Manager manager= session.get(Manager.class, 1);
	   for(Employee em:manager.getEmployee()) {
		   System.out.println(em.getE_name());
		   System.out.println(em.getE_Salary());
	   }
	   Employee e=session.get(Employee.class, 101);
	   for(Manager mn:e.getManager()) {
		   System.out.println(mn.getM_Name());
		   System.out.println(mn.getM_Department());
	   }
	   
	    session.close();
	    sf.close();
		
		
		
		
		
	}

}
