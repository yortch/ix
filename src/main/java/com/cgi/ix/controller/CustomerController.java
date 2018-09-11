package com.cgi.ix.controller;

import com.cgi.ix.domain.Customer;
import com.cgi.ix.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    Logger logger = Logger.getLogger(CustomerController.class.getName());

    @GetMapping("{customerId}")
    @ResponseBody
    public Customer getCustomer(@PathVariable("customerId") Long id) {
        Optional<Customer> customer = customerService.getCustomer(id);
        return customer.orElse(null);
    }

    @PostMapping
    public Customer addCustomer(Customer customer) {
        Customer saved = customerService.addCustomer(customer);
        return saved;
    }

    @GetMapping("/seed/{customerName}")
    @ResponseBody
    public Customer addSeedCustomer(@PathVariable("customerName") String name) {
        logger.log(Level.FINE, "Customer name {0} ", name);

        Customer saved = customerService.addCustomer(name);
        return saved;
    }


}
