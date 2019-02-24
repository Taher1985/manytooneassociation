package com.manytoone.client;

import org.hibernate.Session;

import com.manytoone.entity.Guide;
import com.manytoone.entity.Student;
import com.manytoone.sessionfactory.HibernateSessionFactory;

public class HibernateStudentClient {

	public static void main(String[] args) {

		// Persisting instance
		Session session1 = HibernateSessionFactory.getSession();
		session1.beginTransaction();

		Guide guide1 = new Guide("Tony");
		Student student1 = new Student("Mike", guide1);
		Student student2 = new Student("Tamy", guide1);

		session1.persist(student1);
		session1.persist(student2);
		session1.getTransaction().commit();
		System.out.println("Record Inserted Successfully");
		System.out.println();

		// Getting instance
		Session session2 = HibernateSessionFactory.getSession();
		session2.beginTransaction();
		Student student3 = session2.get(Student.class, student1.getStudentId());
		System.out.print("For Student Id " + student3.getStudentId() + " Associated Guide is : ");
		System.out.println("Guide Name: " + student3.getGuide().getGuideName() + " and Guide Id: "
				+ student3.getGuide().getGuideId());

		session2.getTransaction().commit();

		// Deleting instance
		Session session3 = HibernateSessionFactory.getSession();
		session3.beginTransaction();
		session3.delete(student3);
		session3.getTransaction().commit();
	}

}
