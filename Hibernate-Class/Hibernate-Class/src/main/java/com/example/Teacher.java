package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Teacher 
{
    @Id
    @Column(name = "Tid")
    private int id;

    @Column(name = "TNAME")
    private String name;

    @Column(name = "Tcontact")
    private String contact;

    public Teacher() {}

    public Teacher(int id, String name, String contact) 
    {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getContact() 
    {
        return contact;
    }

    public void setContact(String contact) 
    {
        this.contact = contact;
    }
}