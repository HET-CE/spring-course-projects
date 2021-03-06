package com.hetpatel.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hetpatel.hibernate.demo.entity.Instructor;
import com.hetpatel.hibernate.demo.entity.InstructorDetail;
import com.hetpatel.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();	
	
	    try {
	    	
	    	session.beginTransaction();
	    	
	    	int theId = 1;
	    	Instructor tempInstructor = session.get(Instructor.class, theId);
	    	
	    	//delete process
	    	if(tempInstructor != null) {
	    		System.out.println("deleting "+ tempInstructor);
	    		
	    		// Also delete details object because cascade relationship.
	    		session.delete(tempInstructor);
	    	}
	    	
	    	//commit transaction
	    	session.getTransaction().commit();
	    	
	    }
	    finally {
	    	factory.close();
    	}
	}

}
