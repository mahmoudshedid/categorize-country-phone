package com.shedid.phone.Customer.Service;

import com.shedid.phone.Customer.Model.Customer;
import com.shedid.phone.Customer.Repository.CustomerRepository;
import com.shedid.phone.Customer.Request.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<Customer> findAllCustomersByPhoneCode(CustomerRequest customerRequest) {
        PageRequest pageRequest = PageRequest.of(
                customerRequest.getPage(), customerRequest.getSize(),
                Sort.Direction.fromString(customerRequest.getSortDir()),
                customerRequest.getSort()
        );
        return repository.findByPhone(customerRequest.getCode(), pageRequest);
    }

    @Override
    public Page<Customer> validatePhone(Page<Customer> customers, String regex) {
        customers.forEach(c -> c.setPhoneValid(c.getPhone().matches(regex)));
        return customers;
    }
}
