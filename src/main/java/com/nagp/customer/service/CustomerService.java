package com.nagp.customer.service;

import com.nagp.customer.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<CustomerDto> getAllCustomers();

    CustomerDto getCustomerById(Long customerId);

    List<CustomerDto> createCustomer(CustomerDto customerDto);

    List<CustomerDto> updateCustomer(Long customerId, CustomerDto customerDto);

    List<CustomerDto> deleteCustomer(Long customerId);
}
