package com.backend.jewelcraft.dto.orderDto.cartDto;

public class UpdateCartItemRequestDto {

    private Integer quantity;

    public UpdateCartItemRequestDto() {
    }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
