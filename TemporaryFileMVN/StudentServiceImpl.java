package com.example.student;

import com.example.student.StudentService;

public class StudentServiceImpl implements StudentService {
    public void addStudent(Student student)
    {
        System.out.println("Adding student"+student.getName());

    }
    public void deleteStudent(int rollno)
    {
        System.out.println("Deleting  Student:"+rollno);

    }
    public Student getStudent(int rollno)
    {
        System.out.println("Getting started"+rollno);
        return new Student(rollno,"john");
    }
}