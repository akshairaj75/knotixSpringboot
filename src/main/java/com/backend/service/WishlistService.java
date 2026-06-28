package com.backend.service;

import com.backend.jewelcraft.entity.Wishlist;
import java.util.List;
import java.util.Optional;

public interface WishlistService {

    Wishlist create(Wishlist wishlist);

    Wishlist update(Long id, Wishlist wishlist);

    Wishlist getById(Long id);

    List<Wishlist> getAll();

    void delete(Long id);

    List<Wishlist> getByUserId(Long userId);

    Optional<Wishlist> getByUserIdAndProductId(Long userId, Long productId);

    boolean existsByUserIdAndProductId(Long userId, Long productId);
}
