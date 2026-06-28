package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.OrderItem;
import com.backend.jewelcraft.repository.OrderItemRepository;
import com.backend.jewelcraft.service.OrderItemService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public OrderItem create(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem update(Long id, OrderItem orderItem) {
        getById(id);
        orderItem.setId(id);
        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem getById(Long id) {
        return orderItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OrderItem not found with id: " + id));
    }

    @Override
    public List<OrderItem> getAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        orderItemRepository.deleteById(id);
    }

    @Override
    public List<OrderItem> getByOrderId(Long orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    @Override
    public List<OrderItem> getByProductId(Long productId) {
        return orderItemRepository.findByProductId(productId);
    }

    @Override
    public List<OrderItem> getByProductVariantId(Long productVariantId) {
        return orderItemRepository.findByProductVariantId(productVariantId);
    }
}
