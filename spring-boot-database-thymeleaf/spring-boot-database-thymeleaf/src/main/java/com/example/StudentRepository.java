package com.example;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    // Spring data JPA will automatically implement generate 
    // for basic CRUD operations
}
