package com.shedid.phone.Customer.Repository;

import com.shedid.phone.Customer.Model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

    @Query(value="SELECT c FROM Customer c WHERE c.phone LIKE CONCAT('(',:code,')%')")
    Page<Customer> findByPhone(String code, Pageable pageable);
}
