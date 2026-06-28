package com.backend.jewelcraft.dto.response;

import com.backend.jewelcraft.entity.ProductVariant;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductVariantResponseDto {

    private Long id;
    private Long productId;
    private String sku;
    private String variantName;
    private String color;
    private String size;
    private String finish;
    private BigDecimal price;
    private Integer stockQuantity;
    private boolean isDefault;
    private boolean isActive;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductVariantResponseDto() {
    }

    public static ProductVariantResponseDto fromEntity(ProductVariant entity) {
        if (entity == null) {
            return null;
        }
        ProductVariantResponseDto dto = new ProductVariantResponseDto();
        dto.setId(entity.getId());
        if (entity.getProduct() != null) {
            dto.setProductId(entity.getProduct().getId());
        }
        dto.setSku(entity.getSku());
        dto.setVariantName(entity.getVariantName());
        dto.setColor(entity.getColor());
        dto.setSize(entity.getSize());
        dto.setFinish(entity.getFinish());
        dto.setPrice(entity.getPrice());
        dto.setStockQuantity(entity.getStockQuantity());
        dto.setDefault(entity.isDefaultVariant());
        dto.setActive(entity.isActive());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public String getVariantName() { return variantName; }
    public void setVariantName(String variantName) { this.variantName = variantName; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
    public String getFinish() { return finish; }
    public void setFinish(String finish) { this.finish = finish; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(Integer stockQuantity) { this.stockQuantity = stockQuantity; }
    public boolean isDefault() { return isDefault; }
    public void setDefault(boolean aDefault) { isDefault = aDefault; }
    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
