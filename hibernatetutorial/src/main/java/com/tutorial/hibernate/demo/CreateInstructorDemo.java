package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Course;
import com.tutorial.demo.entity.Instructor;
import com.tutorial.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


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

            Instructor tempInstruction = new Instructor("Klaud", "Kriv", "klaud@gmail.com");

            InstructorDetail tempInstructorDetail = new InstructorDetail("youtubeKKKK", "painting");

            tempInstruction.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            System.out.println("saving instructor: " + tempInstruction);
            session.save(tempInstruction);

            session.getTransaction().commit();

            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }

























    }
}
