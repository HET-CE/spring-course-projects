package com.hetpatel.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hetpatel.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Student.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();	
	
	    try {
	    	// create a student object
	    	Student tempStudent  = new Student("Paul", "wall", "paul@gmail.com");
	    	
	    	//start a transaction
	    	session.beginTransaction();
	    	
	    	//save the student object
	    	session.save(tempStudent);
	    	
	    	//commit transaction
	    	session.getTransaction().commit();
	    	
	    }
	    finally {
	    	factory.close();
    	}
	}

}
