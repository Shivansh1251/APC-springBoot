package com.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class AppOneToMany
{
    public static void main(String[] args) 
    {
        // Create Hibernate session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(StudentDetails.class)
                .addAnnotatedClass(FeeDetails.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try 
        {
            // Start transaction
            session.beginTransaction();

            // Fetch Student by primary key (Roll number)
            int studentRoll = 1001;  // Change this to match existing Roll number
            StudentDetails student = session.find(StudentDetails.class, studentRoll);

            if (student != null) 
            {
                System.out.println("----------------------------------");
                System.out.println("\tStudent Details"); 
                System.out.println("----------------------------------");
                System.out.println(student.getRoll() + "\t" + student.getName() + "\t" + student.getCity());

                // Access the FeeDetails list
                List<FeeDetails> fees = student.getFeeDetails();
                if (fees != null && !fees.isEmpty()) 
                {
                    System.out.println("\t-------------------------------------------------------");
                    System.out.println("\t\tFee Details:");
                    System.out.println("\t-------------------------------------------------------");
                    System.out.println("\tReceipt \tData \t\tMonth \t\tAmount");
                    for (FeeDetails fee : fees) 
                    {
                        System.out.println("\t" + fee.getReceiptNo() + "\t\t" + fee.getFDate() + "\t" + fee.getFeeMonth() + "\t\t" + fee.getAmount());
                    }
                } 
                else 
                {
                    System.out.println("No fee records found.");
                }
            } 
            else 
            {
                System.out.println("Student not found with Roll = " + studentRoll);
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
    }
}