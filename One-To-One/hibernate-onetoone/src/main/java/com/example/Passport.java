package com.example;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
//@Table(name = "Passport")
public class Passport 
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passNo")
    private String passNo;

    // @Temporal(TemporalType.DATE)
    // private Date passRDate;  //If i want to use Date class

    // private String passRDate;
    // private String passExpDate;
    private LocalDate passRDate;
    private LocalDate passExpDate;

    @OneToOne
    @JoinColumn(name = "PID") // This is the foreign key column in the Passport table
    private Person person;

    // Default constructor (required by JPA)
    public Passport() 
    { }

    // Getters and Setters
    public String getPassNo() 
    {
        return passNo;
    }

    public void setPassNo(String passNo) 
    {
        this.passNo = passNo;
    }

    public LocalDate getPassRDate() 
    {
        return passRDate;
    }

    public void setPassRDate(LocalDate passRDate) 
    {
        this.passRDate = passRDate;
    }

    public LocalDate getPassExpDate() 
    {
        return passExpDate;
    }

    public void setPassExpDate(LocalDate passExpDate) 
    {
        this.passExpDate = passExpDate;
    }

    public Person getPerson() 
    {
        return person;
    }

    public void setPerson(Person person) 
    {
        this.person = person;
    }
}   