package com.backend.service;

import com.backend.jewelcraft.entity.OrderItem;
import java.util.List;

public interface OrderItemService {

    OrderItem create(OrderItem orderItem);

    OrderItem update(Long id, OrderItem orderItem);

    OrderItem getById(Long id);

    List<OrderItem> getAll();

    void delete(Long id);

    List<OrderItem> getByOrderId(Long orderId);

    List<OrderItem> getByProductId(Long productId);

    List<OrderItem> getByProductVariantId(Long productVariantId);
}
