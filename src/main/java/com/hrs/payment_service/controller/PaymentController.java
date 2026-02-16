package com.hrs.payment_service.controller;

import com.hrs.payment_service.entity.Payment;
import com.hrs.payment_service.service.PaymentService;
import dto.PaymentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService service;

    @PostMapping("/process")
    public ResponseEntity<Payment> pay(
            @RequestBody PaymentRequestDto req) {

        Payment p = service.processPayment(req);

        if ("FAILED".equals(p.getStatus())) {
            return ResponseEntity.badRequest().body(p);
        }

        return ResponseEntity.ok(p);
    }

    @GetMapping("/reservation/{id}")
    public ResponseEntity<Payment> getByReservation(
            @PathVariable String id) {

        return ResponseEntity.ok(
                service.getByReservation(id));
    }
}
