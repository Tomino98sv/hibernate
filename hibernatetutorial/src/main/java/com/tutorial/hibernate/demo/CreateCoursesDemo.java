package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Course;
import com.tutorial.demo.entity.Instructor;
import com.tutorial.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

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
            Course course1 = new Course("learn java");
            Course course2 = new Course("learn android");

            tempInstructor.add(course1);
            tempInstructor.add(course2);


            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

























    }
}
