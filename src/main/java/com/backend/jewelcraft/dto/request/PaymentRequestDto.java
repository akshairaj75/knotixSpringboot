package com.backend.jewelcraft.dto.request;

import com.backend.jewelcraft.enums.PaymentMethod;
import com.backend.jewelcraft.enums.PaymentStatus;
import java.math.BigDecimal;

public class PaymentRequestDto {

    private Long orderId;
    private PaymentMethod method;
    private PaymentStatus status;
    private BigDecimal amount;
    private String transactionId;
    private String paymentGateway;

    public PaymentRequestDto() {
    }

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
}
