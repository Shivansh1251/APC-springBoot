package com.example;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "FeeDetails")
public class FeeDetails 
{
    @Id
    @Column(name = "ReceiptNo")
    private int receiptNo;

    // Using LocalDate instead of java.util.Date
    @Column(name = "FDate")
    private LocalDate fDate;

    @Column(name = "FeeMonth", length = 20)
    private String feeMonth;

    @Column(name = "Amount")//, precision = 10, scale = 2)
    private double amount;

    // Many FeeDetails -> One StudentDetails
    @ManyToOne
    @JoinColumn(name = "Roll")
    private StudentDetails student;

    // --- Constructors ---
    public FeeDetails() 
    {}

    public FeeDetails(int receiptNo, LocalDate fDate, String feeMonth, double amount, StudentDetails student) 
    {
        this.receiptNo = receiptNo;
        this.fDate = fDate;
        this.feeMonth = feeMonth;
        this.amount = amount;
        this.student = student;
    }

    // --- Getters and Setters ---
    public int getReceiptNo() 
    {
        return receiptNo;
    }

    public void setReceiptNo(int receiptNo) 
    {
        this.receiptNo = receiptNo;
    }

    public LocalDate getFDate() 
    {
        return fDate;
    }

    public void setFDate(LocalDate fDate) 
    {
        this.fDate = fDate;
    }

    public String getFeeMonth() 
    {
        return feeMonth;
    }

    public void setFeeMonth(String feeMonth) 
    {
        this.feeMonth = feeMonth;
    }

    public double getAmount() 
    {
        return amount;
    }

    public void setAmount(double amount) 
    {
        this.amount = amount;
    }

    public StudentDetails getStudent() 
    {
        return student;
    }

    public void setStudent(StudentDetails student) 
    {
        this.student = student;
    }

    // --- toString (optional) ---

    /*@Override
    public String toString() 
    {
        return "FeeDetails{" +
                "receiptNo=" + receiptNo +
                ", date=" + date +
                ", month='" + month + '\'' +
                ", amount=" + amount +
                ", studentRoll=" + (student != null ? student.getRoll() : "null") +
                '}';
    }*/
}