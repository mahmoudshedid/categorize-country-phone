package com.shedid.phone.Customer.Controller;

import com.shedid.phone.Country.Service.CountryService;
import com.shedid.phone.Customer.Model.Customer;
import com.shedid.phone.Customer.Request.CustomerRequest;
import com.shedid.phone.Customer.Response.CustomerResponse;
import com.shedid.phone.Customer.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@CrossOrigin()
@RestController
@Validated
@RequestMapping("/customers")
public class RestCustomerController {

    private static final Logger log = LoggerFactory.getLogger(RestCustomerController.class);

    private final CustomerService service;

    private final CountryService countryService;

    public RestCustomerController(CustomerService service, CountryService countryService) {
        this.service = service;
        this.countryService = countryService;
    }

    @PostMapping(value = "/get/all")
    public CustomerResponse getAllCustomer(@Valid @RequestBody CustomerRequest customerRequest, HttpServletResponse response) {
        Page<Customer> customers = this.service.findAllCustomersByPhoneCode(customerRequest);
        this.service.validatePhone(customers, this.countryService.findRegexByName(customerRequest.getCountry()));
        log.info("[+] Get all customers: {}", customers + " by " + customerRequest.getCode());
//        response.setStatus(200);
        return getCustomerResponse(customers);
    }

    private CustomerResponse getCustomerResponse(Page<Customer> customers) {
        return this.setResponse(customers);
    }

    private CustomerResponse setResponse(Page<Customer> customerPage) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCode(200);
        customerResponse.setStatus("SUCCESS");
        customerResponse.setMessage(null);
        customerResponse.setData(null);
        customerResponse.setDataPage(customerPage);
        return customerResponse;
    }
}
