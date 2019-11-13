package com.kulpekin.rest.restcontroller;

import com.kulpekin.rest.entities.Customer;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/customers/")
public interface ICustomerRestController {

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Customer> saveCustomer(@RequestBody @Valid Customer customer);

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Customer> updateCustomer(@RequestBody @Valid Customer customer);

    @DeleteMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<List<Customer>> findAll();
}
