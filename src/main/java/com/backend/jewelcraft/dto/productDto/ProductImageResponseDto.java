package com.backend.jewelcraft.dto.productDto;

import com.backend.jewelcraft.entity.ProductImage;
import java.time.LocalDateTime;

public class ProductImageResponseDto {

    private Long id;
    private Long productId;
    private Long variantId;
    private String imageUrl;
    private String altText;
    private Integer sortOrder;
    private boolean isPrimary;
    private LocalDateTime createdAt;

    public ProductImageResponseDto() {
    }

    public static ProductImageResponseDto fromEntity(ProductImage entity) {
        if (entity == null) {
            return null;
        }
        ProductImageResponseDto dto = new ProductImageResponseDto();
        dto.setId(entity.getId());
        if (entity.getProduct() != null) {
            dto.setProductId(entity.getProduct().getId());
        }
        if (entity.getProductVariant() != null) {
            dto.setVariantId(entity.getProductVariant().getId());
        }
        dto.setImageUrl(entity.getImageUrl());
        dto.setAltText(entity.getAltText());
        dto.setSortOrder(entity.getSortOrder());
        dto.setPrimary(entity.isPrimaryImage());
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public Long getVariantId() { return variantId; }
    public void setVariantId(Long variantId) { this.variantId = variantId; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getAltText() { return altText; }
    public void setAltText(String altText) { this.altText = altText; }
    public Integer getSortOrder() { return sortOrder; }
    public void setSortOrder(Integer sortOrder) { this.sortOrder = sortOrder; }
    public boolean isPrimary() { return isPrimary; }
    public void setPrimary(boolean primary) { isPrimary = primary; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
