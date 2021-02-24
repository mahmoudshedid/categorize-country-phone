package com.shedid.phone.Customer.Model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.shedid.phone.Common.Entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "customer")
public class Customer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @JsonInclude()
    @Transient
    private boolean valid;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
