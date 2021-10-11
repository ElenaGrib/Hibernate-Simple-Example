package com.company.dao.repository;

import com.company.dao.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> getEmployee(String name);

    Optional<Employee>  saveEmployee(String name, String company);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(Long id);

    List<Employee> getAll();
}
