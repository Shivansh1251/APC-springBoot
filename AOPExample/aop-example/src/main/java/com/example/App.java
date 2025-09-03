package com.example;

import java.text.Annotation;

/**
 * Hello world!
 *
 */
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        // try with resources
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

            GreetingService svc = ctx.getBean(GreetingService.class);

            // Successful call
            String msg = svc.greet("Shivansh");
            System.out.println("MSG received: " + msg);
            // Intentional failure to show @AfterThrowing
            try {
                svc.fail();
            } catch (Exception e) {
                System.out.println("Main caught: " + e.getMessage());
            }

        }

    }
}
