package com.backend.jewelcraft.dto.cartDto;

import com.backend.jewelcraft.entity.CartItem;
import com.backend.jewelcraft.entity.ProductImage;
import com.backend.jewelcraft.entity.ProductVariant;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CartItemResponseDto {

    private Long id;
    private Long cartId;
    private Long variantId;
    private Long productId;
    private String productName;
    private String sku;
    private String variantName;
    private String color;
    private String size;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal lineTotal;
    private String imageUrl;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CartItemResponseDto() {
    }

    public static CartItemResponseDto fromEntity(CartItem entity) {
        if (entity == null) {
            return null;
        }
        CartItemResponseDto dto = new CartItemResponseDto();
        dto.setId(entity.getId());
        if (entity.getCart() != null) {
            dto.setCartId(entity.getCart().getId());
        }
        ProductVariant variant = entity.getProductVariant();
        if (variant != null) {
            dto.setVariantId(variant.getId());
            dto.setSku(variant.getSku());
            dto.setVariantName(variant.getVariantName());
            dto.setColor(variant.getColor());
            dto.setSize(variant.getSize());
            dto.setPrice(variant.getPrice());
            dto.setImageUrl(findVariantImageUrl(variant));
            if (variant.getProduct() != null) {
                dto.setProductId(variant.getProduct().getId());
                dto.setProductName(variant.getProduct().getName());
            }
        }
        dto.setQuantity(entity.getQuantity());
        dto.setLineTotal(calculateLineTotal(dto.getPrice(), dto.getQuantity()));
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    private static BigDecimal calculateLineTotal(BigDecimal price, Integer quantity) {
        if (price == null || quantity == null) {
            return BigDecimal.ZERO;
        }
        return price.multiply(BigDecimal.valueOf(quantity));
    }

    private static String findVariantImageUrl(ProductVariant variant) {
        if (variant.getProductImages() == null || variant.getProductImages().isEmpty()) {
            return null;
        }
        return variant.getProductImages().stream()
                .filter(ProductImage::isPrimaryImage)
                .findFirst()
                .orElse(variant.getProductImages().get(0))
                .getImageUrl();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getVariantId() {
        return variantId;
    }

    public void setVariantId(Long variantId) {
        this.variantId = variantId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getLineTotal() {
        return lineTotal;
    }

    public void setLineTotal(BigDecimal lineTotal) {
        this.lineTotal = lineTotal;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
