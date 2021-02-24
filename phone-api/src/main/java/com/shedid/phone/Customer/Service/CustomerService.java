package com.shedid.phone.Customer.Service;

import com.shedid.phone.Customer.Model.Customer;
import org.springframework.data.domain.Page;


public interface CustomerService {

    Page<Customer> findAllCustomers(int page, int size, String sortDir, String sort);

    Page<Customer> findAllCustomersByPhoneCode(String code, int page, int size, String sortDir, String sort);
}
