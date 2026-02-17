package com.hrs.payment_service.service;

import com.hrs.payment_service.entity.Payment;
import com.hrs.payment_service.repo.PaymentRepository;
import dto.PaymentRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Slf4j
@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repo;

    public Payment processPayment(PaymentRequestDto req) {
log.info("service call: processpayment");
        boolean success = simulateGateway();
log.info("payment gateway returned" + success);
        Payment payment = Payment.builder()
                .reservationId(req.getReservationId())
                .customerId(req.getCustomerId())
                .amount(req.getAmount())
                .method(req.getMethod())
                .status(success ? "SUCCESS" : "FAILED")
                .createdAt(Instant.now())
                .build();

        return repo.save(payment);
    }

    private boolean simulateGateway() {
        return Math.random() > 0.2; // 80% success
    }

    public Payment getByReservation(String resId) {
        return repo.findByReservationId(resId)
                .orElseThrow(() ->
                        new RuntimeException("Payment Data not found for reservation id: " + resId));
    }
}
