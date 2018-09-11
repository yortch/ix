package com.cgi.ix.repository;


import com.cgi.ix.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {



}
