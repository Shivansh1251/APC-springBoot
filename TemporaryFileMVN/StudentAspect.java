package com.example.student;

import org.aspectj.lang.JointPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class StudentAspect {

    @Before("execution(* com.example.student.StudentService.*(..))")
    public void logBefore(JointPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.example.student.StudentService.*(..))")
    public void logAfter(JointPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature().getName());
    }
}
