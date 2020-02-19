package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Course;
import com.tutorial.demo.entity.Instructor;
import com.tutorial.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {


            session.beginTransaction();

            int theId=1;
            Instructor tempInstructor = (Instructor) session.get(Instructor.class, theId);

            System.out.println("Instructor detail: " + tempInstructor);
            System.out.println("Instructor courses: " + tempInstructor.getCourses());

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

























    }
}
