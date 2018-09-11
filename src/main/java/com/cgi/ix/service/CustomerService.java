package com.cgi.ix.service;

import com.cgi.ix.domain.Customer;

import java.util.Optional;

public interface CustomerService {

    public Optional<Customer> getCustomer(Long id);

    public Customer addCustomer(Customer customer);

    public Customer addCustomer(String customerName);
}
