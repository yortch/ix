package com.cgi.ix.service;

import com.cgi.ix.domain.Customer;
import com.cgi.ix.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    Logger logger = Logger.getLogger(CustomerServiceImpl.class.getName());

    public Optional<Customer> getCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer;
    }

    public Customer addCustomer(Customer customer) {
        logger.log(Level.FINE, "Customer name: {0}", customer.getName());
        Customer saved = customerRepository.save(customer);
        return saved;
    }

    public Customer addCustomer(String customerName) {
        logger.log(Level.FINE, ">addCustomer, customer name: {0}", customerName);
        Customer customer = new Customer();
        customer.setName(customerName);
        Customer saved = addCustomer(customer);
        return saved;
    }
}
