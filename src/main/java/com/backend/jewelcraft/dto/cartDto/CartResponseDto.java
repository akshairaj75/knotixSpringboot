package com.backend.jewelcraft.dto.cartDto;

import com.backend.jewelcraft.entity.Cart;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class CartResponseDto {

    private Long id;
    private Long userId;
    private List<CartItemResponseDto> items;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public CartResponseDto() {
    }

    public static CartResponseDto fromEntity(Cart entity) {
        if (entity == null) {
            return null;
        }
        CartResponseDto dto = new CartResponseDto();
        dto.setId(entity.getId());
        if (entity.getUser() != null) {
            dto.setUserId(entity.getUser().getId());
        }
        if (entity.getCartItems() != null) {
            dto.setItems(entity.getCartItems().stream().map(CartItemResponseDto::fromEntity).toList());
        }
        dto.setTotalAmount(calculateTotal(dto.getItems()));
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }

    private static BigDecimal calculateTotal(List<CartItemResponseDto> items) {
        if (items == null) {
            return BigDecimal.ZERO;
        }
        return items.stream()
                .map(CartItemResponseDto::getLineTotal)
                .filter(amount -> amount != null)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public List<CartItemResponseDto> getItems() { return items; }
    public void setItems(List<CartItemResponseDto> items) { this.items = items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
