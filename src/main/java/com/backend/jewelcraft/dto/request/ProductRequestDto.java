package com.backend.jewelcraft.dto.request;

import com.backend.jewelcraft.enums.ProductStatus;
import java.math.BigDecimal;

public class ProductRequestDto {

    private Long categoryId;
    private String name;
    private String slug;
    private String shortDescription;
    private String description;
    private BigDecimal basePrice;
    private String material;
    private String craftType;
    private String careInstructions;
    private ProductStatus status;
    private Boolean isFeatured;

    public ProductRequestDto() {
    }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }
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
    public Boolean getIsFeatured() { return isFeatured; }
    public void setIsFeatured(Boolean isFeatured) { this.isFeatured = isFeatured; }
}
