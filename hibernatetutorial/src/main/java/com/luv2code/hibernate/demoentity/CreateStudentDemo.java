package com.luv2code.hibernate.demoentity;

import org.hibernate.SessionFactory;
import org.hibernate.Session;

import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            System.out.println("Creating student object");
            Student tempStudent1 = new Student("Paul","Wall","paul@luv2code.com");
            Student tempStudent2 = new Student("Mary","Public","mary@luv2code.com");
            Student tempStudent3 = new Student("Bonita","Applebaum","bonita@luv2code.com");

            session.beginTransaction();

            System.out.println("Saving the student");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            System.out.println("Commit transaction");
            session.getTransaction().commit();
            System.out.println(tempStudent1.getId());

            //getting student by id
            session = factory.getCurrentSession();
            session.beginTransaction();
            System.out.println("getting student with id: "+tempStudent3.getId());
            Student studentFromDB = session.get(Student.class,tempStudent3.getId());
            System.out.println("Get complete "+studentFromDB);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            studentFromDB.setFirstName("Harabin");
            session.save(studentFromDB);
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            String querry = "update Student set email='foo@gmail.com'";
            session.createQuery(querry).executeUpdate();
            session.getTransaction().commit();

            System.out.println("Done");
        }catch (Exception exp) {
            exp.printStackTrace();
        }finally {
            session.close();
        }

        //pozriet videa od 187
    }
}
