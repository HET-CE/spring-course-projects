package com.hetpatel.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hetpatel.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				 .configure("hibernate.cfg.xml")
				 .addAnnotatedClass(Student.class)
				 .buildSessionFactory();

			Session session = factory.getCurrentSession();	

		try {
			// 	create a student object
			Student tempStudent1  = new Student("abhi", "patel", "abhi@gmail.com");
			Student tempStudent2  = new Student("het", "patel", "het@gmail.com");
			Student tempStudent3  = new Student("deven", "patel", "deven@gmail.com");

			//	start a transaction
			session.beginTransaction();

			//	save the student object
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			//	commit transaction
			session.getTransaction().commit();

		}
		finally {
			factory.close();
		}

	}

}
