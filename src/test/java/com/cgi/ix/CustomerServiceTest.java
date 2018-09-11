package com.cgi.ix;

import com.cgi.ix.domain.Customer;
import com.cgi.ix.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Level;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    Logger logger = Logger.getLogger(CustomerServiceTest.class.getName());

    @Autowired
    CustomerService customerService;

    @Test
    public void addCustomerTest() {
        Customer customer = new Customer();
        String customerName = "Test Customer";
        customer.setName(customerName);
        Customer saved = customerService.addCustomer(customer);
        assertThat(saved).isNotNull();
        assertThat(saved.getName()).isEqualTo(customerName);
        assertThat(saved.getId()).isNotNull();
        logger.log(Level.INFO, "Customer id: {0}", saved.getId().toString());
    }

    @Test
    public void addSeedCustomerTest() {
        String customerName = "Test Customer";
        Customer saved = customerService.addCustomer(customerName);
        assertThat(saved).isNotNull();
        assertThat(saved.getName()).isEqualTo(customerName);
        assertThat(saved.getId()).isNotNull();
        logger.log(Level.INFO, "Customer id: {0}", saved.getId().toString());
    }


    @Test
    public void getCustomerTest() {
        Customer customer = new Customer();
        String customerName = "Test Customer";
        customer.setName(customerName);
        Customer saved = customerService.addCustomer(customer);
        Customer found = customerService.getCustomer(saved.getId()).get();
        assertThat(found).isNotNull();
        assertThat(found.getName()).isEqualTo(customerName);
        assertThat(found.getId()).isNotNull();
        logger.log(Level.INFO, "Customer id: {0}", saved.getId().toString());
    }

}
