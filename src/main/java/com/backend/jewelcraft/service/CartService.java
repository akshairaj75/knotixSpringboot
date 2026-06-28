package com.backend.jewelcraft.service;

import com.backend.jewelcraft.entity.Cart;
import java.util.List;
import java.util.Optional;

public interface CartService {

    Cart create(Cart cart);

    Cart update(Long id, Cart cart);

    Cart getById(Long id);

    List<Cart> getAll();

    void delete(Long id);

    Optional<Cart> getByUserId(Long userId);

    boolean existsByUserId(Long userId);
}
