package com.example;

//import com.example.Teacher;
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
                .addAnnotatedClass(Teacher.class)
                .addAnnotatedClass(Class.class)
                .buildSessionFactory();

            session = factory.openSession();
            session.beginTransaction();

            // Fetch all students
            List<Teacher> students = session.createQuery("from Teacher", Teacher.class).getResultList();
            for (Teacher s : students) 
            {
                System.out.println(s.getId() + " " + s.getName() + " " + s.getContact());
            }
            session.getTransaction().commit();
            session = factory.openSession();
            session.beginTransaction();
            List<Class> classes = session.createQuery("from Class", Class.class).getResultList();
            for (Class c : classes) 
            {
                System.out.println(c.getCno() + " " + c.getcRoomNo() + " " + c.getTeacherName());
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