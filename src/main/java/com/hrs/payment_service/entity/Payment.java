package com.hrs.payment_service.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Document(collection = "payments")
@Data
@Builder
public class Payment {

    @Id
    private String id;

    private String reservationId;

    private String customerId;

    private BigDecimal amount;

    private String status; // SUCCESS / FAILED / REFUNDED

    private String method; // CARD / UPI / NETBANKING

    private Instant createdAt;
}

