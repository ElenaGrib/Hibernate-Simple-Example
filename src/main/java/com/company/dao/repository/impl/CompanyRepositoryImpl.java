package com.company.dao.repository.impl;

import com.company.dao.entity.Address;
import com.company.dao.entity.Company;
import com.company.dao.repository.CompanyRepository;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

public class CompanyRepositoryImpl implements CompanyRepository {
    private SessionFactory sessionFactory;


    @Override
    public Optional<Company> getCompany(String name) {
        return sessionFactory.getCurrentSession()
                .createQuery("select e from " + Company.class.getSimpleName() + " e where e.name = :name", Company.class)
                .setParameter("name", name)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public Optional<Company> saveCompany(String name, Address address) {
        Company company = new Company();
        sessionFactory.getCurrentSession()
                .save(name, address);
        return Optional.of(company);
    }

    @Override
    public Company updateCompany(Company company) {
        sessionFactory.getCurrentSession().createQuery("update e" + Company.class);
        return company;
    }

    @Override
    public void deleteCompany(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete e " + Company.class.getSimpleName() + "where e.id=:id", Company.class);
    }

    @Override
    public List<Company> getAll() {
        return null;
    }
}
