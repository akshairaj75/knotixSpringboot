package com.backend.jewelcraft.dto.orderDto;

import com.backend.jewelcraft.entity.OrderItem;
import java.math.BigDecimal;

public class OrderItemResponseDto {

    private Long id;
    private Long orderId;
    private Long productId;
    private Long variantId;
    private String productName;
    private String sku;
    private String variantDetails;
    private String productImageUrl;
    private BigDecimal unitPrice;
    private Integer quantity;
    private BigDecimal lineTotal;

    public OrderItemResponseDto() {
    }

    public static OrderItemResponseDto fromEntity(OrderItem entity) {
        if (entity == null) {
            return null;
        }
        OrderItemResponseDto dto = new OrderItemResponseDto();
        dto.setId(entity.getId());
        if (entity.getOrder() != null) {
            dto.setOrderId(entity.getOrder().getId());
        }
        if (entity.getProduct() != null) {
            dto.setProductId(entity.getProduct().getId());
        }
        if (entity.getProductVariant() != null) {
            dto.setVariantId(entity.getProductVariant().getId());
        }
        dto.setProductName(entity.getProductName());
        dto.setSku(entity.getSku());
        dto.setVariantDetails(entity.getVariantDetails());
        dto.setProductImageUrl(entity.getProductImageUrl());
        dto.setUnitPrice(entity.getUnitPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setLineTotal(entity.getLineTotal());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Long getVariantId() { return variantId; }
    public void setVariantId(Long variantId) { this.variantId = variantId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getVariantDetails() { return variantDetails; }
    public void setVariantDetails(String variantDetails) { this.variantDetails = variantDetails; }
    public String getProductImageUrl() { return productImageUrl; }
    public void setProductImageUrl(String productImageUrl) { this.productImageUrl = productImageUrl; }
    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getLineTotal() { return lineTotal; }
    public void setLineTotal(BigDecimal lineTotal) { this.lineTotal = lineTotal; }
}
