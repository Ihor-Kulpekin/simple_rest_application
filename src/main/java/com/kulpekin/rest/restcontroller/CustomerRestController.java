package com.kulpekin.rest.restcontroller;

import com.kulpekin.rest.entities.Customer;
import com.kulpekin.rest.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerRestController implements ICustomerRestController {

    private final CustomerService customerService;

    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }


    public ResponseEntity<Customer> saveCustomer(@Valid Customer customer) {

        HttpHeaders httpHeaders = new HttpHeaders();

        if(customer==null){
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
        customerService.save(customer);
        return new ResponseEntity<Customer>(customer,httpHeaders,HttpStatus.CREATED);
    }

    public ResponseEntity<Customer> updateCustomer(@Valid Customer customer) {

        HttpHeaders httpHeaders = new HttpHeaders();

        if(customer==null){
            return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Customer>(customer,httpHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Customer> deleteCustomer(int id) {

        Customer deletedCustomer = customerService.getById(id);

        if(deletedCustomer==null){
            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
        }
        customerService.delete(id);

        return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Customer>> findAll() {

        List<Customer> customers = customerService.findAll();

        if(customers.isEmpty()){
            return new ResponseEntity<List<Customer>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Customer>>(customers,HttpStatus.OK);
    }

}
