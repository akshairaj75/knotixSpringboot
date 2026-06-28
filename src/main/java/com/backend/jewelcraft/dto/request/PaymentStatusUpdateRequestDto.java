package com.backend.jewelcraft.dto.request;

import com.backend.jewelcraft.enums.PaymentStatus;

public class PaymentStatusUpdateRequestDto {

    private PaymentStatus paymentStatus;

    public PaymentStatusUpdateRequestDto() {
    }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }
}
