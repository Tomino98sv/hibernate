package com.luv2code.hibernate.demoentity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try{
            session.beginTransaction();
            int studentId = 1;
            Student myStudent = session.get(Student.class, studentId);
            session.delete(myStudent);
            session.createQuery("delete from student where id=2").executeUpdate();

            session.getTransaction().commit();
        }catch (Exception exp) {
            exp.printStackTrace();
        }finally {
            session.close();
        }

        //pozriet videa od 187
    }

}
