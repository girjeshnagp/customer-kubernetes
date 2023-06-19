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

    @PostMapping
    public ResponseEntity<List<CustomerDto>> createCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<List<CustomerDto>> updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto) {
        CustomerDto customerDto1 = customerService.getCustomerById(customerId);
        if (Objects.isNull(customerDto1)) {
            return ResponseEntity.notFound().build();
        }else {
            customerDto.builder().customerId(customerId);
            return ResponseEntity.ok(customerService.updateCustomer(customerId, customerDto));
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<List<CustomerDto>> deleteCustomer(@PathVariable Long customerId) {
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        if (Objects.isNull(customerDto)) {
            return ResponseEntity.notFound().build();
        }else {
            return ResponseEntity.ok(customerService.deleteCustomer(customerId));
        }
    }
}
