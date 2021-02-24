package com.shedid.phone.Customer.Service;

import com.shedid.phone.Customer.Model.Customer;
import com.shedid.phone.Customer.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public Page<Customer> findAllCustomers(int page, int size, String sortDir, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        return repository.findAll(pageRequest);
    }

    @Override
    public Page<Customer> findAllCustomersByPhoneCode(String code, int page, int size, String sortDir, String sort) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.fromString(sortDir), sort);
        return repository.findByPhone(code, pageRequest);
    }
}
