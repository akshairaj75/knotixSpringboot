package com.backend.jewelcraft.service;

import com.backend.jewelcraft.entity.CartItem;
import java.util.List;
import java.util.Optional;

public interface CartItemService {

    CartItem create(CartItem cartItem);

    CartItem update(Long id, CartItem cartItem);

    CartItem getById(Long id);

    List<CartItem> getAll();

    void delete(Long id);

    List<CartItem> getByCartId(Long cartId);

    Optional<CartItem> getByCartIdAndProductVariantId(Long cartId, Long productVariantId);

    boolean existsByCartIdAndProductVariantId(Long cartId, Long productVariantId);
}
