package com.hetpatel.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hetpatel.hibernate.demo.entity.Student;

public class DeleteStudentdemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();

		Session session = factory.getCurrentSession();	
		
		try {
		int studentId = 1;	
		
		session = factory.getCurrentSession();	
		session.beginTransaction();
		
		Student myStudent = session.get(Student.class, studentId);
		
		session.delete(myStudent);
		//commit transaction

		// Alternate way of delete
		session.createQuery("delete from Student where id=2").executeUpdate();

		session.getTransaction().commit();
		
		}
		finally {
		factory.close();
		}
	}

}
