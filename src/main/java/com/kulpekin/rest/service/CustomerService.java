package com.kulpekin.rest.service;

import com.kulpekin.rest.entities.Customer;

import java.util.List;

public interface CustomerService {

    Customer getById(int id);

    Customer save(Customer customer);

    void delete(int id);

    List<Customer> findAll();

}
