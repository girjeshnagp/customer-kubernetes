package com.nagp.customer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "TBL_CUSTOMER")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
        @Id
        @Column(name = "CUSTOMER_ID")
        private Long customerId;
        @Column(name = "CUSTOMER_NAME")
        private String customerName;
        @Column(name = "CUSTOMER_EMAIL", unique = true)
        private String customerEmail;
        @Column(name = "CUSTOMER_PHONE", unique = true)
        private String customerPhone;
        @Column(name = "CUSTOMER_ADDRESS")
        private String customerAddress;
}
