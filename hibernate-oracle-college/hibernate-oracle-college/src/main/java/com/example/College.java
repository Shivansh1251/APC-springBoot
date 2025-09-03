package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class College 
{
    @Id
    @Column(name = "CID")
    private int id;

    @Column(name = "CNAME")
    private String name;

    @Column(name = "CLOCATION")
    private String location;

    public College() {}

    public College(int id, String name, String location) 
    {
        this.id = id;
        this.name = name;
        this.location = location;
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

    public String getLocation() 
    {
        return location;
    }

    public void setLocation(String location) 
    {
        this.location = location;
    }
}