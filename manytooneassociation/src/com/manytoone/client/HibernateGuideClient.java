package com.manytoone.client;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.manytoone.entity.Guide;
import com.manytoone.entity.Student;
import com.manytoone.sessionfactory.HibernateSessionFactory;

public class HibernateGuideClient {

	public static void main(String[] args) {

		// Persisting instance
		Session session1 = HibernateSessionFactory.getSession();
		session1.beginTransaction();

		Guide guide1 = new Guide("Johny");
		Student student1 = new Student("Samy", guide1);
		Student student2 = new Student("Tamy", guide1);
		Student student3 = new Student("Namy", guide1);

		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);

		guide1.setStudents(list);

		session1.persist(guide1);

		session1.getTransaction().commit();

		System.out.println("Record Inserted Successfully");

		
		// Getting instance
		Session session2 = HibernateSessionFactory.getSession();
		session2.beginTransaction();
		Guide guide2 = session2.get(Guide.class, guide1.getGuideId());
		System.out.println("-----------");
		System.out.println("For Guide Id " + guide2.getGuideId() + " Associated Students are : ");
		for (Student student : guide2.getStudents()) {
			System.out.println(
					"Student Name: " + student.getStudentName() + " and Student Id: " + student.getStudentId());
		}
		session2.getTransaction().commit();

		// Deleting instance
		Session session3 = HibernateSessionFactory.getSession();
		session3.beginTransaction();
		session3.delete(guide2);
		session3.getTransaction().commit();

	}

}
