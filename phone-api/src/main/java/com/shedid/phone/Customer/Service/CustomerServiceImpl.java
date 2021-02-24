package com.shedid.phone.Customer.Service;

import com.shedid.phone.Customer.Model.Customer;
import com.shedid.phone.Customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> findAllCustomersByPhoneCode(String code) {
        return repository.findByPhone(code);
    }
}
