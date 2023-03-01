package com.example.springdatajpahw.dao;


import com.example.springdatajpahw.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
