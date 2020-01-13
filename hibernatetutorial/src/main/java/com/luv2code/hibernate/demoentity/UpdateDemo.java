package com.luv2code.hibernate.demoentity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            Student studentFromDB = session.get(Student.class,3);

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

    }
}
