package com.nagp.customer.controller;

import com.nagp.customer.dto.CustomerDto;
import com.nagp.customer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long customerId) {
        var customerDto = customerService.getCustomerById(customerId);
        return Objects.nonNull(customerDto) ?
                ResponseEntity.ok(customerDto) : ResponseEntity.notFound().build();
    }

    @GetMapping("/create")
    public ResponseEntity<CustomerDto> createCustomer(@RequestParam String customerName) {
        return ResponseEntity.ok(customerService.createCustomer(customerName));
    }
}
