package com.backend.jewelcraft.dto.orderDto;

import java.math.BigDecimal;

public class CustomOrderQuoteRequestDto {

    private BigDecimal quotedPrice;

    public CustomOrderQuoteRequestDto() {
    }

    public BigDecimal getQuotedPrice() { return quotedPrice; }
    public void setQuotedPrice(BigDecimal quotedPrice) { this.quotedPrice = quotedPrice; }
}
