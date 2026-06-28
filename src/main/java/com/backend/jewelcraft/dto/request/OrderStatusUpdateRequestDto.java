package com.backend.jewelcraft.dto.request;

import com.backend.jewelcraft.enums.OrderStatus;

public class OrderStatusUpdateRequestDto {

    private OrderStatus status;

    public OrderStatusUpdateRequestDto() {
    }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}
