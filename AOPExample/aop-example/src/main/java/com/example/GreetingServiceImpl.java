package com.example;
import org.springframework.stereotype.Service;
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greet(String name)
    {
        System.out.println("GreetingServiceImpl.greet() excecuting...");
        return "Hello"+name+"I";
    }
    @Override

public String fail()
    {
        System.out.println("GreetingServiceImpl.fail() excecuting...");
        throw new RuntimeException("Boom! Something is Failing intentionally");
    }
}