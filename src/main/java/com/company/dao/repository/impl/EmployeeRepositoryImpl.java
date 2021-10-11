package com.company.dao.repository.impl;

import com.company.dao.entity.Employee;
import com.company.dao.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;


public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final SessionFactory sessionFactory;

    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Employee> getEmployee(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select e from " + Employee.class.getSimpleName() + " e where e.name = :name", Employee.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Optional<Employee> saveEmployee(String name, String company) {
        Employee employee = new Employee();
        employee.setName(name);
        sessionFactory.getCurrentSession()
                .save(employee);
        return Optional.of(employee);
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().createQuery("update e" + Employee.class);
        return employee;
    }

    @Override
    public void deleteEmployee(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete e " + Employee.class.getSimpleName() + "where e.id=:id", Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Employee", Employee.class)
                .list();
    }
}
