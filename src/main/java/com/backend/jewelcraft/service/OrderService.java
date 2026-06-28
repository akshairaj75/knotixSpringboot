package com.backend.jewelcraft.service;

import com.backend.jewelcraft.entity.Order;
import com.backend.jewelcraft.enums.OrderStatus;
import com.backend.jewelcraft.enums.PaymentStatus;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Order create(Order order);

    Order update(Long id, Order order);

    Order getById(Long id);

    List<Order> getAll();

    void delete(Long id);

    Optional<Order> getByOrderNo(String orderNo);

    boolean existsByOrderNo(String orderNo);

    List<Order> getByUserId(Long userId);

    List<Order> getByStatus(OrderStatus status);

    List<Order> getByPaymentStatus(PaymentStatus paymentStatus);
}
