package com.example.springdatajpahw.service;

import com.example.springdatajpahw.dao.EmployeeRepo;
import com.example.springdatajpahw.entity.Employee;
import com.example.springdatajpahw.exceptions.EmployeeException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getById(int id) {
        Employee employee = employeeRepo.findById(id).orElse(null); // Возвращает Optional, поэтому нужно вызвать get()

        if (employee == null) {
            throw new EmployeeException("ID: " + id + " does not exist");
        }
        return employee;
    }

    @Override
    public void add(Employee employee) {
        employee.setId(null);
        employeeRepo.save(employee);

    }

    @Override
    public void update(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void removeById(int id) {
        Employee employee = getById(id);

        if (employee == null) {
            throw new EmployeeException("ID: " + id + " does not exist");
        }
        employeeRepo.deleteById(id);
    }
}
