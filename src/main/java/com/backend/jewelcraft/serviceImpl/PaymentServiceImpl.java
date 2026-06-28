package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.Payment;
import com.backend.jewelcraft.enums.PaymentStatus;
import com.backend.jewelcraft.repository.PaymentRepository;
import com.backend.jewelcraft.service.PaymentService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Payment create(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Long id, Payment payment) {
        getById(id);
        payment.setId(id);
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getById(Long id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Payment not found with id: " + id));
    }

    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        paymentRepository.deleteById(id);
    }

    @Override
    public List<Payment> getByOrderId(Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    @Override
    public Optional<Payment> getByTransactionId(String transactionId) {
        return paymentRepository.findByTransactionId(transactionId);
    }

    @Override
    public boolean existsByTransactionId(String transactionId) {
        return paymentRepository.existsByTransactionId(transactionId);
    }

    @Override
    public List<Payment> getByStatus(PaymentStatus status) {
        return paymentRepository.findByStatus(status);
    }
}
