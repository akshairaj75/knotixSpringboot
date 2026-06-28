package com.backend.jewelcraft.dto.request;

import com.backend.jewelcraft.enums.PaymentStatus;

public class PaymentStatusRequestDto {

    private PaymentStatus status;

    public PaymentStatusRequestDto() {
    }

    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
}
