package com.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Class 
{
    @Id
    @Column(name = "Cno")
    private int Cno;

    @Column(name = "cRoomNo")
    private int cRoomNo;

    @Column(name = "cTeacherName")
    private String teacherName;

    public Class() {}

    public Class(int Cno, int cRoomNo, String teacherName) 
    {
        this.Cno = Cno;
        this.cRoomNo = cRoomNo;
        this.teacherName = teacherName;
    }

    public int getCno() 
    {
        return Cno;
    }

    public void setCno(int Cno) 
    {
        this.Cno = Cno;
    }

    public int getcRoomNo() 
    {
        return cRoomNo;
    }

    public void setcRoomNo(int cRoomNo) 
    {
        this.cRoomNo = cRoomNo;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }

    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    
}