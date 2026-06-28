package com.backend.jewelcraft.dto.request;

public class ProductReviewApprovalRequestDto {

    private Boolean isApproved;

    public ProductReviewApprovalRequestDto() {
    }

    public Boolean getIsApproved() { return isApproved; }
    public void setIsApproved(Boolean isApproved) { this.isApproved = isApproved; }
}
