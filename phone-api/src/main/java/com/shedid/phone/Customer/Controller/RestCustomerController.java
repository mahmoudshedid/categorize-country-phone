package com.shedid.phone.Customer.Controller;

import com.shedid.phone.Customer.Model.Customer;
import com.shedid.phone.Customer.Request.CustomerRequest;
import com.shedid.phone.Customer.Response.CustomerResponse;
import com.shedid.phone.Customer.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin()
@RestController
@RequestMapping("/customers")
public class RestCustomerController {

    private static final Logger log = LoggerFactory.getLogger(RestCustomerController.class);

    private final CustomerService service;

    private final Map<String, String> country;

    public RestCustomerController(CustomerService service) {
        this.service = service;
        this.country = new HashMap<>();
        this.country.put("Cameroon", "\\(237\\)\\ ?[2368]\\d{7,8}$");
        this.country.put("Ethiopia", "\\(251\\)\\ ?[1-59]\\d{8}$");
        this.country.put("Morocco", "\\(212\\)\\ ?[5-9]\\d{8}$");
        this.country.put("Mozambique", "\\(258\\)\\ ?[28]\\d{7,8}$");
        this.country.put("Uganda", "\\(256\\)\\ ?\\d{9}$");
    }

    @GetMapping(value = "/get/all")
    public CustomerResponse getAllCustomer(@RequestBody CustomerRequest customerRequest, HttpServletResponse response) {
        Page<Customer> customers = service.findAllCustomersByPhoneCode(
                customerRequest.getCode(),
                customerRequest.getPage(),
                customerRequest.getSize(),
                customerRequest.getSortDir(),
                customerRequest.getSort()
        );
        this.validatePhone(customers, this.country.get(customerRequest.getCountry()));
        log.info("[+] Get all customers: {}", customers + " by " + customerRequest.getCode());
        response.setStatus(200);
        return getCustomerResponse(customers);
    }

    private void validatePhone(Page<Customer> customers, String regex) {
        customers.forEach(c -> c.setValid(c.getPhone().matches(regex)));
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
