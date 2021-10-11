package com.company.dao.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "client")
public class Client extends BaseEntity {
    @Column
    private String name;
}
