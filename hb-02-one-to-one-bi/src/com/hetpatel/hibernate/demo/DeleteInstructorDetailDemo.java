package com.hetpatel.hibernate.demo;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hetpatel.hibernate.demo.entity.Instructor;
import com.hetpatel.hibernate.demo.entity.InstructorDetail;
import com.hetpatel.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								 .configure("hibernate.cfg.xml")
								 .addAnnotatedClass(Instructor.class)
								 .addAnnotatedClass(InstructorDetail.class)
								 .buildSessionFactory();
		
	Session session = factory.getCurrentSession();	
	
	    try {
	    	
	    	session.beginTransaction();
	    	
	    	int theId = 3;
	    	InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
	    	//commit transaction

	    	System.out.println("tempInstructorDetail : " + tempInstructorDetail);
	    	
	    	System.out.println("the associate Instructor is " + tempInstructorDetail.getInstructor());

	    	/* In bi-directional relationship if you update or delete in
	    	   one its affect another one and if you want to delete in only one table than you have to 
	    	   change cascade like below,
	    	   cascade = CascadeType.ALL   to    cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	    	   and then here you have to break the link also.
	    	*/
	    	
	    	// breaking the link
	    	tempInstructorDetail.getInstructor().setInstructorDetail(null);
	    	
	    	// Deleting Process
	    	session.delete(tempInstructorDetail);
	    	
	    	session.getTransaction().commit();
	    	
	    }
	    catch(Exception e) {
	    	e.printStackTrace();
	    }
	    finally {
	    	session.close();
	    	factory.close();
    	}
	}

}
