package com.hetpatel.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hetpatel.hibernate.demo.entity.Course;
import com.hetpatel.hibernate.demo.entity.Instructor;
import com.hetpatel.hibernate.demo.entity.InstructorDetail;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .addAnnotatedClass(Course.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();	
	
	    try {
	    	
	    	Instructor tempInstructor = new Instructor("deven", "patel", "deven@gmail.com");
	    
	    	InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.hetpatel.com/youtube","Mobile games");
	    	//start a transaction
	    	
	    	tempInstructor.setInstructorDetail(tempInstructorDetail);
	    	
	    	session.beginTransaction();
	    	
	    	// This will save tempInstructorDetail because CascadeType.ALL 
	    	session.save(tempInstructor);
	    	
	    	//commit transaction
	    	session.getTransaction().commit();
	    	
	    }
	    finally {
	    	session.close();
	    	factory.close();
    	}
	}

}
