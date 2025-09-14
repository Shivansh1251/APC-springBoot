package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class App 
{
    public static void main(String[] args) 
    {
        // Create Hibernate SessionFactory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = null;
        try 
        {
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Fetch all Person records (which includes passport via mapping)
            List<Person> persons = session.createQuery("FROM Person", Person.class).getResultList();

            if (persons.isEmpty()) 
            {
                System.out.println("No person records found.");
            } 
            else 
            {
                for (Person person : persons) 
                {
                    System.out.println("----------- Person Details -----------");
                    System.out.println("ID       : " + person.getId());
                    System.out.println("Name     : " + person.getName());
                    System.out.println("Age      : " + person.getContact());

                    Passport passport = person.getPassport();
                    if (passport != null) 
                    {
                        System.out.println("Passport ID     : " + passport.getPassNo());
                        System.out.println("Passport Number : " + passport.getPassRDate());
                        System.out.println("Passport Number : " + passport.getPassExpDate());
                    } 
                    else 
                    {
                        System.out.println("No passport assigned.");
                    }
                    System.out.println("--------------------------------------\n");
                }
            }
            session.getTransaction().commit();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (session != null && session.isOpen()) 
                session.close();
            if (factory != null && !factory.isClosed())
                factory.close();
        }
        System.exit(0);
    }
}