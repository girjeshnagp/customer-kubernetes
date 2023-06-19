package com.nagp.customer.config;

import com.nagp.customer.dto.CustomerDto;
import com.nagp.customer.service.CustomerService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class DataInitializer {

    private final CustomerService customerService;

    public DataInitializer(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostConstruct
    public void initializeData() {
        if (CollectionUtils.isEmpty(customerService.getAllCustomers())) {
            // Data does not exist, initialize with dummy data
            var customerDto = CustomerDto.builder().customerId(1L).customerName("Girjesh Soni")
                    .customerEmail("girjesh.soni@gmail.com").customerAddress("New York")
                    .customerPhone("7788998899").build();
            var customerDto2 = CustomerDto.builder().customerId(2L).customerName("Bharat Dube")
                    .customerEmail("bharat.dube@gmail.com").customerAddress("San Francisco")
                    .customerPhone("8877889988").build();
            var customerDto3 = CustomerDto.builder().customerId(3L).customerName("Payal verma")
                    .customerEmail("payal.verma@gmail.com").customerAddress("New Jersey")
                    .customerPhone("9988778899").build();
            var customerDto4 = CustomerDto.builder().customerId(4L).customerName("Rahul Singh")
                    .customerEmail("rahul.singh@gmail.com").customerAddress("Amsterdam")
                    .customerPhone("8877669988").build();
            var customerDto5 = CustomerDto.builder().customerId(5L).customerName("Rajesh Kumar")
                    .customerEmail("rajesh.kumar@gmail.com").customerAddress("London")
                    .customerPhone("9988778499").build();

            List.of(customerDto, customerDto2, customerDto3, customerDto4, customerDto5)
                    .forEach(customerService::createCustomer);
        }
    }
}
