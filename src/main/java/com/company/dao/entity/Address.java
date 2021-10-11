package com.company.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
public class Address {
    @Column
    private String street;
    @Column
    private String city;
}
