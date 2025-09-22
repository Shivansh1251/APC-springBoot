package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student")  // table in Oracle DB
public class Student 
{
    @Id
    private Integer roll;
    private String name;
    private Integer marks;

    // getters and setters
    public Integer getRoll() 
    { 
        return roll; 
    }
    public void setRoll(Integer roll) 
    { 
        this.roll = roll; 
    }
    public String getName() 
    { 
        return name; 
    }
    public void setName(String name) 
    { 
        this.name = name; 
    }
    public Integer getMarks() 
    { 
        return marks; 
    }
    public void setMarks(Integer marks) 
    { 
        this.marks = marks; 
    }
}