package com.nagp.customer.service.impl;

import com.nagp.customer.dto.CustomerDto;
import com.nagp.customer.mapper.ModelDtoMapper;
import com.nagp.customer.repository.CustomerRepository;
import com.nagp.customer.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final ModelDtoMapper modelDtoMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, ModelDtoMapper modelDtoMapper) {
        this.customerRepository = customerRepository;
        this.modelDtoMapper = modelDtoMapper;
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(modelDtoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        return customerRepository.findById(customerId).map(modelDtoMapper::toDto).orElse(null);
    }

    @Override
    public CustomerDto createCustomer(String customerName) {
        var customer = CustomerDto.builder().customerName(customerName).build();
        return null;
    }
}
