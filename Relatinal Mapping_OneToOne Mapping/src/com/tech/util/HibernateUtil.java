package com.tech.util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.tech.entity.Student;
import com.tech.entity.Teacher;


public class HibernateUtil {
	
	private static StandardServiceRegistry registry;
	
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() {
		
		Map<String, Object> setting =new HashMap<>();
		
		setting.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		setting.put(Environment.URL, "jdbc:mysql://localhost:3306/relational_mapping");
		setting.put(Environment.USER, "root");
		setting.put(Environment.PASS, "Root");
		
		setting.put(Environment.HBM2DDL_AUTO, "create");
		setting.put(Environment.SHOW_SQL, "true");
		setting.put(Environment.DIALECT, "org.hibernate.dialect.MySQL55Dialect");
		
		registry=new StandardServiceRegistryBuilder().applySettings(setting).build();
		
		MetadataSources msd=new MetadataSources(registry).addAnnotatedClass(Student.class).addAnnotatedClass(Teacher.class);
	
		Metadata md=msd.getMetadataBuilder().build();
		
		sf=md.getSessionFactoryBuilder().build();
		
		
		return sf;
		
	}

}
