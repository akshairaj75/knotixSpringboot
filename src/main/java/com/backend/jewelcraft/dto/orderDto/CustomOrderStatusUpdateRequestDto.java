package com.backend.jewelcraft.dto.orderDto;

import com.backend.jewelcraft.enums.CustomOrderStatus;

public class CustomOrderStatusUpdateRequestDto {

    private CustomOrderStatus status;

    public CustomOrderStatusUpdateRequestDto() {
    }

    public CustomOrderStatus getStatus() { return status; }
    public void setStatus(CustomOrderStatus status) { this.status = status; }
}
