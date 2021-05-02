package com.hetpatel.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hetpatel.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();	
	
	    try {
	    	//start a transaction
	    	session.beginTransaction();
	    	
	    	List<Student> theStudents = session.createQuery("from Student").getResultList();
	    	for(Student st : theStudents) {
	    		System.out.println(st);
	    	}
	    	System.out.println();
	    	
	    	theStudents = session.createQuery("from Student s where s.lastName = 'patel'").getResultList();
	    	for(Student st : theStudents) {
	    		System.out.println(st);
	    	}
	    	System.out.println();
	    	
	    	theStudents = session.createQuery("from Student s where" 
	    	 + " s.lastName='patel' AND s.firstName='het'").getResultList();
	    	for(Student st : theStudents) {
	    		System.out.println(st);
	    	}
	    	System.out.println();
	    	
	    	theStudents = session.createQuery("from Student s where" + " s.email LIKE '%gmail.com'").getResultList();
	    	for(Student st : theStudents) {
	    		System.out.println(st);
	    	}
	    	//commit transaction
	    	session.getTransaction().commit();
	    	
	    }
	    finally {
	    	factory.close();
    	}
	}

}
