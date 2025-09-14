package com.example;

import jakarta.persistence.*;

@Entity
@Table(name = "Person")
public class Person 
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PID")
    private int id;

    @Column(name = "PNAME")
    private String name;

    @Column(name = "PCONTACT")
    private String contact;

    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    private Passport passport;

    // Getters and Setters
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

    public Passport getPassport() 
    { 
        return passport; 
    }
    public void setPassport(Passport passport) 
    {
        this.passport = passport;
        passport.setPerson(this);  // to maintain bidirectional sync
    }
}