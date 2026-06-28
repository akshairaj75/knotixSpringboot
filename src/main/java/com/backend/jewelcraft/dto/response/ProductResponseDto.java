package com.backend.jewelcraft.dto.response;

import com.backend.jewelcraft.entity.Product;
import com.backend.jewelcraft.enums.ProductStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ProductResponseDto {

    private Long id;
    private Long categoryId;
    private String categoryName;
    private String name;
    private String slug;
    private String shortDescription;
    private String description;
    private BigDecimal basePrice;
    private String material;
    private String craftType;
    private String careInstructions;
    private ProductStatus status;
    private boolean isFeatured;
    private List<ProductVariantResponseDto> variants;
    private List<ProductImageResponseDto> images;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public ProductResponseDto() {
    }

    public static ProductResponseDto fromEntity(Product entity) {
        if (entity == null) {
            return null;
        }
        ProductResponseDto dto = new ProductResponseDto();
        dto.setId(entity.getId());
        if (entity.getCategory() != null) {
            dto.setCategoryId(entity.getCategory().getId());
            dto.setCategoryName(entity.getCategory().getName());
        }
        dto.setName(entity.getName());
        dto.setSlug(entity.getSlug());
        dto.setShortDescription(entity.getShortDescription());
        dto.setDescription(entity.getDescription());
        dto.setBasePrice(entity.getBasePrice());
        dto.setMaterial(entity.getMaterial());
        dto.setCraftType(entity.getCraftType());
        dto.setCareInstructions(entity.getCareInstructions());
        dto.setStatus(entity.getStatus());
        dto.setFeatured(entity.isFeatured());
        if (entity.getProductVariants() != null) {
            dto.setVariants(entity.getProductVariants().stream().map(ProductVariantResponseDto::fromEntity).toList());
        }
        if (entity.getProductImages() != null) {
            dto.setImages(entity.getProductImages().stream().map(ProductImageResponseDto::fromEntity).toList());
        }
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
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
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }
    public String getCraftType() { return craftType; }
    public void setCraftType(String craftType) { this.craftType = craftType; }
    public String getCareInstructions() { return careInstructions; }
    public void setCareInstructions(String careInstructions) { this.careInstructions = careInstructions; }
    public ProductStatus getStatus() { return status; }
    public void setStatus(ProductStatus status) { this.status = status; }
    public boolean isFeatured() { return isFeatured; }
    public void setFeatured(boolean featured) { isFeatured = featured; }
    public List<ProductVariantResponseDto> getVariants() { return variants; }
    public void setVariants(List<ProductVariantResponseDto> variants) { this.variants = variants; }
    public List<ProductImageResponseDto> getImages() { return images; }
    public void setImages(List<ProductImageResponseDto> images) { this.images = images; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
