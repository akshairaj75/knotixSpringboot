package com.backend.jewelcraft.dto.response;

import com.backend.jewelcraft.entity.Product;
import com.backend.jewelcraft.entity.ProductImage;
import com.backend.jewelcraft.enums.ProductStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductListResponseDto {

    private Long id;
    private Long categoryId;
    private String categoryName;
    private String name;
    private String slug;
    private String shortDescription;
    private BigDecimal basePrice;
    private ProductStatus status;
    private boolean isFeatured;
    private String primaryImageUrl;
    private LocalDateTime createdAt;

    public ProductListResponseDto() {
    }

    public static ProductListResponseDto fromEntity(Product entity) {
        if (entity == null) {
            return null;
        }
        ProductListResponseDto dto = new ProductListResponseDto();
        dto.setId(entity.getId());
        if (entity.getCategory() != null) {
            dto.setCategoryId(entity.getCategory().getId());
            dto.setCategoryName(entity.getCategory().getName());
        }
        dto.setName(entity.getName());
        dto.setSlug(entity.getSlug());
        dto.setShortDescription(entity.getShortDescription());
        dto.setBasePrice(entity.getBasePrice());
        dto.setStatus(entity.getStatus());
        dto.setFeatured(entity.isFeatured());
        dto.setPrimaryImageUrl(findPrimaryImageUrl(entity));
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    private static String findPrimaryImageUrl(Product entity) {
        if (entity.getProductImages() == null || entity.getProductImages().isEmpty()) {
            return null;
        }
        return entity.getProductImages().stream()
                .filter(ProductImage::isPrimaryImage)
                .findFirst()
                .orElse(entity.getProductImages().get(0))
                .getImageUrl();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSlug() { return slug; }
    public void setSlug(String slug) { this.slug = slug; }
    public String getShortDescription() { return shortDescription; }
    public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
    public ProductStatus getStatus() { return status; }
    public void setStatus(ProductStatus status) { this.status = status; }
    public boolean isFeatured() { return isFeatured; }
    public void setFeatured(boolean featured) { isFeatured = featured; }
    public String getPrimaryImageUrl() { return primaryImageUrl; }
    public void setPrimaryImageUrl(String primaryImageUrl) { this.primaryImageUrl = primaryImageUrl; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
