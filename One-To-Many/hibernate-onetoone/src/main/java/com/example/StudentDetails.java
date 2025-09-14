package com.example;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "StudentDetails")
public class StudentDetails 
{
    @Id
    @Column(name = "Roll")
    private int roll;

    @Column(name = "Name", nullable = true, length = 20)
    private String name;

    @Column(name = "Contact", length = 15)
    private String contact;

    @Column(name = "City", length = 10)
    private String city;

    // One Student -> Many FeeDetails
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FeeDetails> feeDetails;

    // --- Constructors ---
    public StudentDetails() 
    {}

    public StudentDetails(int roll, String name, String contact, String city) 
    {
        this.roll = roll;
        this.name = name;
        this.contact = contact;
        this.city = city;
    }

    // --- Getters and Setters ---
    public int getRoll() 
    {
        return roll;
    }

    public void setRoll(int roll) 
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

    public String getContact() 
    {
        return contact;
    }

    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getCity() 
    {
        return city;
    }

    public void setCity(String city) 
    {
        this.city = city;
    }

    public List<FeeDetails> getFeeDetails() 
    {
        return feeDetails;
    }

    public void setFeeDetails(List<FeeDetails> feeDetails) 
    {
        this.feeDetails = feeDetails;
    }

    // --- toString (Optional for debugging) ---

    /*@Override
    public String toString() 
    {
        return "StudentDetails{" +
                "roll=" + roll +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", city='" + city + '\'' +
                '}';
    }*/
}