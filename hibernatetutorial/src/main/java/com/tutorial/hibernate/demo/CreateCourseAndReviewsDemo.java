package com.tutorial.hibernate.demo;

import com.tutorial.demo.entity.Course;
import com.tutorial.demo.entity.Instructor;
import com.tutorial.demo.entity.InstructorDetail;
import com.tutorial.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();

            Course tempCourse = new Course("novy kurz");
            tempCourse.addReview(new Review("Super kurz to bol"));
            tempCourse.addReview(new Review("Uzasne"));
            tempCourse.addReview(new Review("No neviem neviem"));

            System.out.println("saving the course : " + tempCourse);
            System.out.println(tempCourse.getReviews());

            session.save(tempCourse);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }

























    }
}
