package com.hrs.payment_service.repo;

import com.hrs.payment_service.entity.Payment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PaymentRepository
        extends MongoRepository<Payment, String> {

    Optional<Payment> findByReservationId(String reservationId);
}
