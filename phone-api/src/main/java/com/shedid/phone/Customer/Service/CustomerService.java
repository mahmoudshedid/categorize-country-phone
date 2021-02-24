package com.shedid.phone.Customer.Service;

import com.shedid.phone.Customer.Model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAllCustomersByPhoneCode(String code);
}
