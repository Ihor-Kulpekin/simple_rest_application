package com.kulpekin.rest.service;

import com.kulpekin.rest.entities.Customer;
import com.kulpekin.rest.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getById(int id) {
        return customerRepository.getOne(id);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(int id) {
        Customer deletedCustomer = getById(id);
        customerRepository.delete(deletedCustomer);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
