package com.company.dao.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "company")
public class Company extends BaseEntity {
    @Column
    private String name;

    @OneToMany(mappedBy = "company")
    private List<Employee> employees;

    @ManyToMany
    @JoinTable(name = "company_client",
            joinColumns = @JoinColumn(name = "fk_company_id"),
            inverseJoinColumns = @JoinColumn(name = "fk_client_id")
    )
    private List<Client> clients;

    @Embedded
    private Address address;
}
