package com.example;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@Configuration
@ComponentScan(basePackages = "com.example")
@EnableAspectJAutoProxy // turn on @Aspect support (proxy-based)
public class AppConfig { 
    //Statement here
    // AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    // GreetingService service = context.getBean(GreetingService.class);
    // service.greet();
    // context.close();
}