package com.backend.jewelcraft.dto.response;

import com.backend.jewelcraft.entity.Product;
import com.backend.jewelcraft.entity.ProductImage;
import com.backend.jewelcraft.entity.Wishlist;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WishlistResponseDto {

    private Long id;
    private Long userId;
    private Long productId;
    private String productName;
    private String productSlug;
    private BigDecimal basePrice;
    private String primaryImageUrl;
    private LocalDateTime createdAt;

    public WishlistResponseDto() {
    }

    public static WishlistResponseDto fromEntity(Wishlist entity) {
        if (entity == null) {
            return null;
        }
        WishlistResponseDto dto = new WishlistResponseDto();
        dto.setId(entity.getId());
        if (entity.getUser() != null) {
            dto.setUserId(entity.getUser().getId());
        }
        Product product = entity.getProduct();
        if (product != null) {
            dto.setProductId(product.getId());
            dto.setProductName(product.getName());
            dto.setProductSlug(product.getSlug());
            dto.setBasePrice(product.getBasePrice());
            dto.setPrimaryImageUrl(findPrimaryImageUrl(product));
        }
        dto.setCreatedAt(entity.getCreatedAt());
        return dto;
    }

    private static String findPrimaryImageUrl(Product product) {
        if (product.getProductImages() == null || product.getProductImages().isEmpty()) {
            return null;
        }
        return product.getProductImages().stream()
                .filter(ProductImage::isPrimaryImage)
                .findFirst()
                .orElse(product.getProductImages().get(0))
                .getImageUrl();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public Long getProductId() { return productId; }
    public void setProductId(Long productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductSlug() { return productSlug; }
    public void setProductSlug(String productSlug) { this.productSlug = productSlug; }
    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
    public String getPrimaryImageUrl() { return primaryImageUrl; }
    public void setPrimaryImageUrl(String primaryImageUrl) { this.primaryImageUrl = primaryImageUrl; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
