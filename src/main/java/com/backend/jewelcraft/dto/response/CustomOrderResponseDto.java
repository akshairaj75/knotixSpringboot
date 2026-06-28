package com.backend.jewelcraft.dto.response;

import com.backend.jewelcraft.entity.CustomOrderRequest;
import com.backend.jewelcraft.enums.CustomOrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CustomOrderResponseDto {

    private Long id;
    private Long userId;
    private String name;
    private String phone;
    private String email;
    private String title;
    private String description;
    private String referenceImageUrl;
    private BigDecimal budgetMin;
    private BigDecimal budgetMax;
    private BigDecimal quotedPrice;
    private CustomOrderStatus status;
    private Long convertedOrderId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CustomOrderResponseDto() {
    }

    public static CustomOrderResponseDto fromEntity(CustomOrderRequest entity) {
        if (entity == null) {
            return null;
        }
        CustomOrderResponseDto dto = new CustomOrderResponseDto();
        dto.setId(entity.getId());
        if (entity.getUser() != null) {
            dto.setUserId(entity.getUser().getId());
        }
        dto.setName(entity.getName());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setReferenceImageUrl(entity.getReferenceImageUrl());
        dto.setBudgetMin(entity.getBudgetMin());
        dto.setBudgetMax(entity.getBudgetMax());
        dto.setQuotedPrice(entity.getQuotedPrice());
        dto.setStatus(entity.getStatus());
        if (entity.getConvertedOrder() != null) {
            dto.setConvertedOrderId(entity.getConvertedOrder().getId());
        }
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getReferenceImageUrl() { return referenceImageUrl; }
    public void setReferenceImageUrl(String referenceImageUrl) { this.referenceImageUrl = referenceImageUrl; }
    public BigDecimal getBudgetMin() { return budgetMin; }
    public void setBudgetMin(BigDecimal budgetMin) { this.budgetMin = budgetMin; }
    public BigDecimal getBudgetMax() { return budgetMax; }
    public void setBudgetMax(BigDecimal budgetMax) { this.budgetMax = budgetMax; }
    public BigDecimal getQuotedPrice() { return quotedPrice; }
    public void setQuotedPrice(BigDecimal quotedPrice) { this.quotedPrice = quotedPrice; }
    public CustomOrderStatus getStatus() { return status; }
    public void setStatus(CustomOrderStatus status) { this.status = status; }
    public Long getConvertedOrderId() { return convertedOrderId; }
    public void setConvertedOrderId(Long convertedOrderId) { this.convertedOrderId = convertedOrderId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
