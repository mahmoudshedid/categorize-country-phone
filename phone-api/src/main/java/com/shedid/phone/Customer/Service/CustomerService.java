package com.shedid.phone.Customer.Service;

import com.shedid.phone.Customer.Model.Customer;
import com.shedid.phone.Customer.Request.CustomerRequest;
import org.springframework.data.domain.Page;

public interface CustomerService {

    Page<Customer> findAllCustomersByPhoneCode(CustomerRequest customerRequest);

    Page<Customer> validatePhone(Page<Customer> customers, String regex);
}
