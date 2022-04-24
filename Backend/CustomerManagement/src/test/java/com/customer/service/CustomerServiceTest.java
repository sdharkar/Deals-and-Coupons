package com.customer.service;

import com.customer.model.Customer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    CustomerServiceImpl customerService = mock(CustomerServiceImpl.class);

//    @Test
//    @DisplayName("Find customer by Name")
//    void findByName() {
//        Customer customer = new Customer(
//                1, "a", "pass", new ArrayList<String>(), "suv", "email", "Customer");
//        when(customerService.findByName("customer")).thenReturn(customer);
//    }
}
