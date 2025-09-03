package com.example.student;

public interface StudentService
{
    //adds ,deletes acc to roll no and get student according to student
    void addStudent(Student student );
    void deleteStudent(int rollno);
    Student getStudent(int rollno);
}