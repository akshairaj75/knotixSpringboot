package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.Order;
import com.backend.jewelcraft.enums.OrderStatus;
import com.backend.jewelcraft.enums.PaymentStatus;
import com.backend.jewelcraft.repository.OrderRepository;
import com.backend.jewelcraft.service.OrderService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order create(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Long id, Order order) {
        getById(id);
        order.setId(id);
        return orderRepository.save(order);
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        orderRepository.deleteById(id);
    }

    @Override
    public Optional<Order> getByOrderNo(String orderNo) {
        return orderRepository.findByOrderNo(orderNo);
    }

    @Override
    public boolean existsByOrderNo(String orderNo) {
        return orderRepository.existsByOrderNo(orderNo);
    }

    @Override
    public List<Order> getByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    @Override
    public List<Order> getByStatus(OrderStatus status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Order> getByPaymentStatus(PaymentStatus paymentStatus) {
        return orderRepository.findByPaymentStatus(paymentStatus);
    }
}
