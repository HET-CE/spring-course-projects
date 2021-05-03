package com.hetpatel.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hetpatel.hibernate.demo.entity.Instructor;
import com.hetpatel.hibernate.demo.entity.InstructorDetail;
import com.hetpatel.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();	
	
	    try {
	    	
	    	Instructor tempInstructor = new Instructor("het", "patel", "het@gmail.com");
	    
	    	InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.hetpatel.com/youtube","love programming");
	    	//start a transaction
	    	
	    	tempInstructor.setInstructorDetail(tempInstructorDetail);
	    	
	    	session.beginTransaction();
	    	
	    	// This will save tempInstructorDetail because CascadeType.ALL 
	    	session.save(tempInstructor);
	    	
	    	//commit transaction
	    	session.getTransaction().commit();
	    	
	    }
	    finally {
	    	factory.close();
    	}
	}

}
