package com.example.student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.student.Student;

public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("StudentConfig.xml");
 
        StudentService studentService = (StudentService) context.getBean("studentService");
        Student student = new Student(100, "John");
        studentService.addStudent(student);
        studentService.deleteStudent(100);
        studentService.getStudent(100);
    }
}
