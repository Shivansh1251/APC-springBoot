package com.example;

//import com.example.College;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import main.java.com.example;

import java.util.List;

public class App 
{
    public static void main(String[] args) 
    {
        SessionFactory factory = null;
        Session session = null;
        try
        {
            factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(College.class)
                .buildSessionFactory();

            session = factory.openSession();
            session.beginTransaction();

            // Fetch all students
            List<College> students = session.createQuery("from College", College.class).getResultList();
            for (College s : students) 
            {
                System.out.println(s.getId() + " " + s.getName() + " " + s.getLocation());
            }

            session.getTransaction().commit();
        }
        finally
        {
            // session.close();
            // factory.close();
            if (session != null) 
                session.close();
            if (factory != null) 
                factory.close();
        }
    }
}