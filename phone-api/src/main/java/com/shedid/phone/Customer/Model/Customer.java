package com.shedid.phone.Customer.Model;

import com.shedid.phone.Common.Entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
