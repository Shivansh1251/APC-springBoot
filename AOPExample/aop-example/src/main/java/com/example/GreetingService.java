package com.example;

public interface GreetingService {
    String greet(String name);

    String fail();// to demonstrate @AfterThrowing

}