package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    // Pointcut for any greet(..) method in GreetingService
    @Pointcut("execution(* com.example.GreetingService.greet(..))")
    public void greetMethod() 
    {}

    // Pointcut for any public method in our package (for timing)
    @Pointcut("execution(public * com.example..*(..))")
    public void anyPublicMethod() 
    {}

    @Before("greetMethod() && args(name)")
    public void beforeGreet(String name) 
    {
        System.out.println("[AOP] @Before - About to greet: " + name);
    }

    @AfterReturning(pointcut = "greetMethod()", returning = "result")
    public void afterReturning(Object result) 
    {
        System.out.println("[AOP] @AfterReturning - Got result: " + result);
    }

    @AfterThrowing(pointcut = "execution(* com.example.GreetingService.fail(..))", throwing = "ex")
    public void afterThrowing(Exception ex) 
    {
        System.out.println("[AOP] @AfterThrowing - Exception: " + ex.getMessage());
    }

    @Around("anyPublicMethod()")
    public Object aroundAnyPublic(ProceedingJoinPoint pjp) throws Throwable 
    {
        long t0 = System.nanoTime();
        try 
        {
            System.out.println("[AOP] @Around - Enter: " + pjp.getSignature());
            Object out = pjp.proceed();
            return out;
        } 
        finally 
        {
            long t1 = System.nanoTime();
            System.out.println("[AOP] @Around - Exit: " + pjp.getSignature() + " took " + (t1 - t0)/1_000_000.0 + " ms");
        }
    }
}