package com.nagp.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public record CustomerDto(
        Long customerId,
        String customerName,
        String customerEmail,
        String customerPhone,
        String customerAddress) {
}
