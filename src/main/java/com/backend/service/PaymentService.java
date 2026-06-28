package com.backend.service;

import com.backend.jewelcraft.entity.Payment;
import com.backend.jewelcraft.enums.PaymentStatus;
import java.util.List;
import java.util.Optional;

public interface PaymentService {

    Payment create(Payment payment);

    Payment update(Long id, Payment payment);

    Payment getById(Long id);

    List<Payment> getAll();

    void delete(Long id);

    List<Payment> getByOrderId(Long orderId);

    Optional<Payment> getByTransactionId(String transactionId);

    boolean existsByTransactionId(String transactionId);

    List<Payment> getByStatus(PaymentStatus status);
}
