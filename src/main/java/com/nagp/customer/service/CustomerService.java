package com.nagp.customer.service;

import com.nagp.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long customerId);

    CustomerDto createCustomer(String customerName);
}
