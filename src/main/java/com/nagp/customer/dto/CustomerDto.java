package com.nagp.customer.dto;

import lombok.Builder;

@Builder
public record CustomerDto(
        Long customerId,
        String customerName,
        String customerEmail,
        String customerPhone,
        String customerAddress) {
}
