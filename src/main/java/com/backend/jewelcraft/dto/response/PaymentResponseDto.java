package com.backend.jewelcraft.dto.response;

import com.backend.jewelcraft.entity.Payment;
import com.backend.jewelcraft.enums.PaymentMethod;
import com.backend.jewelcraft.enums.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PaymentResponseDto {

    private Long id;
    private Long orderId;
    private PaymentMethod method;
    private PaymentStatus status;
    private BigDecimal amount;
    private String transactionId;
    private String paymentGateway;
    private LocalDateTime paidAt;
    private LocalDateTime createdAt;

    public PaymentResponseDto() {
    }

    public static PaymentResponseDto fromEntity(Payment entity) {
        if (entity == null) {
            return null;
        }
        PaymentResponseDto dto = new PaymentResponseDto();
        dto.setId(entity.getId());
        if (entity.getOrder() != null) {
            dto.setOrderId(entity.getOrder().getId());
        }
        dto.setMethod(entity.getMethod());
        dto.setStatus(entity.getStatus());
        dto.setAmount(entity.getAmount());
        dto.setTransactionId(entity.getTransactionId());
        dto.setPaymentGateway(entity.getPaymentGateway());
        dto.setPaidAt(entity.getPaidAt());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public PaymentMethod getMethod() { return method; }
    public void setMethod(PaymentMethod method) { this.method = method; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus status) { this.status = status; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getPaymentGateway() { return paymentGateway; }
    public void setPaymentGateway(String paymentGateway) { this.paymentGateway = paymentGateway; }
    public LocalDateTime getPaidAt() { return paidAt; }
    public void setPaidAt(LocalDateTime paidAt) { this.paidAt = paidAt; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
