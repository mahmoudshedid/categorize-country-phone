package com.shedid.phone.Customer.Controller;

import com.shedid.phone.Customer.Model.Customer;
import com.shedid.phone.Customer.Response.CustomerResponse;
import com.shedid.phone.Customer.Service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/customers")
public class RestCustomerController {

    private static final Logger log = LoggerFactory.getLogger(RestCustomerController.class);

    private final CustomerService service;

    public RestCustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping(value = "/get/all", params = { "code" })
    public CustomerResponse getAllCustomer(@RequestParam("code") String code, HttpServletResponse response) {
        List<Customer> customers = service.findAllCustomersByPhoneCode(code);
        if (customers != null) {
            log.info("[+] Get all customers: {}", customers + " by " + code);
            response.setStatus(200);
            return getCustomerResponse(customers);
        } else {
            log.error("[+] There is no customers.");
            response.setStatus(409);
            return getCustomerResponse();
        }
    }

    private CustomerResponse getCustomerResponse() {
        return this.setResponse("ERROR", "[+] There is no customers.", null);
    }

    private CustomerResponse getCustomerResponse(List<Customer> customers) {
        return this.setResponse("SUCCESS", null, customers);
    }

    private CustomerResponse setResponse(String status, String message, List<Customer> customers) {
        CustomerResponse customerResponse = new CustomerResponse();
        customerResponse.setCode(200);
        customerResponse.setStatus(status);
        customerResponse.setMessage(message);
        customerResponse.setData(customers);
        customerResponse.setDataPage(null);
        return customerResponse;
    }
}
