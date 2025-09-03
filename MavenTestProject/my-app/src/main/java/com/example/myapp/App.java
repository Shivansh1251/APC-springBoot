//package com.example.myapp;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {

        JFrame fr = new JFrame("Data Entry Form");
        JPanel p = new JPanel();
        fr.getContentPane().add(p);
        fr.setSize(400, 300);
        fr.setVisible(true);
        JLabel l1 = new JLabel("Enter Roll Number : ");
        p.setLayout(null);
        p.add(l1);
        // System.out.println( "Hello World!" );

        // System.out.println( "Shivansh Garg" );

        // System.out.println( "Java mein maven" );
    }
}
