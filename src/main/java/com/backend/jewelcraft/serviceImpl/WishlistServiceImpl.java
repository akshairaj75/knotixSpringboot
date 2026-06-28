package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.Wishlist;
import com.backend.jewelcraft.repository.WishlistRepository;
import com.backend.jewelcraft.service.WishlistService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class WishlistServiceImpl implements WishlistService {

    private final WishlistRepository wishlistRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    @Override
    public Wishlist create(Wishlist wishlist) {
        return wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist update(Long id, Wishlist wishlist) {
        getById(id);
        wishlist.setId(id);
        return wishlistRepository.save(wishlist);
    }

    @Override
    public Wishlist getById(Long id) {
        return wishlistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Wishlist not found with id: " + id));
    }

    @Override
    public List<Wishlist> getAll() {
        return wishlistRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        wishlistRepository.deleteById(id);
    }

    @Override
    public List<Wishlist> getByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    @Override
    public Optional<Wishlist> getByUserIdAndProductId(Long userId, Long productId) {
        return wishlistRepository.findByUserIdAndProductId(userId, productId);
    }

    @Override
    public boolean existsByUserIdAndProductId(Long userId, Long productId) {
        return wishlistRepository.existsByUserIdAndProductId(userId, productId);
    }
}
