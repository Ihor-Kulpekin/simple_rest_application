package com.kulpekin.rest.restcontroller;

import com.kulpekin.rest.entities.Customer;
import com.kulpekin.rest.service.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@Rollback
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRestControllerTest {

    @InjectMocks
    private CustomerRestController restController;

    @Mock
    private CustomerService customerService;

    @Test
    public void testSaveCustomer() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        Customer customer = new Customer();

        Mockito.when(customerService.save(ArgumentMatchers.any(Customer.class))).thenReturn(customer);

        ResponseEntity<Customer> responseEntity = restController.saveCustomer(customer);

        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }

    @Test
    public void testUpdateCustomer() {

    }

    @Test
    public void testDeleteCustomer() {
    }

    @Test
    public void testFindAll() {

        List<Customer> listCustomers = customerService.findAll();
        listCustomers.add(new Customer());

        Mockito.when(customerService.findAll()).thenReturn(listCustomers);

        ResponseEntity<List<Customer>> responseEntity = restController.findAll();

        assertEquals(200,responseEntity.getStatusCodeValue());
    }
}