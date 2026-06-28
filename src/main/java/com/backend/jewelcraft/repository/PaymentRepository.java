package com.backend.jewelcraft.repository;

import com.backend.jewelcraft.entity.Payment;
import com.backend.jewelcraft.enums.PaymentStatus;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByOrderId(Long orderId);

    Optional<Payment> findByTransactionId(String transactionId);

    boolean existsByTransactionId(String transactionId);

    List<Payment> findByStatus(PaymentStatus status);
}
