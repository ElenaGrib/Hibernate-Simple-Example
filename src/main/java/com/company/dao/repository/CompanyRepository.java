package com.company.dao.repository;

import com.company.dao.entity.Address;
import com.company.dao.entity.Company;

import java.util.List;
import java.util.Optional;

public interface CompanyRepository {
    Optional<Company> getCompany(String name);

    Optional<Company>  saveCompany(String name, Address address);

    Company updateCompany(Company company);

    void deleteCompany(Long id);

    List<Company> getAll();
}
