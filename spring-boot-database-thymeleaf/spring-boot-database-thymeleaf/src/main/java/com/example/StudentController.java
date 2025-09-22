package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController 
{

    @Autowired
    private StudentRepository repo;

    // Load form page
    @GetMapping("/")    
    public String loadForm(Model model) 
    {
        model.addAttribute("student", new Student());
        return "student"; // student.html
    }

    // Insert student
    @PostMapping("/insert")
    public String insert(@ModelAttribute Student student, Model model) 
    {
        repo.save(student);
        model.addAttribute("msg", "Inserted Successfully!");
        model.addAttribute("student", new Student()); // reset form
        return "student";
    }
}