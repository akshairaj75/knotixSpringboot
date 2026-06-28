package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.CartItem;
import com.backend.jewelcraft.repository.CartItemRepository;
import com.backend.jewelcraft.service.CartItemService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemServiceImpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem create(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem update(Long id, CartItem cartItem) {
        getById(id);
        cartItem.setId(id);
        return cartItemRepository.save(cartItem);
    }

    @Override
    public CartItem getById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CartItem not found with id: " + id));
    }

    @Override
    public List<CartItem> getAll() {
        return cartItemRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        cartItemRepository.deleteById(id);
    }

    @Override
    public List<CartItem> getByCartId(Long cartId) {
        return cartItemRepository.findByCartId(cartId);
    }

    @Override
    public Optional<CartItem> getByCartIdAndProductVariantId(Long cartId, Long productVariantId) {
        return cartItemRepository.findByCartIdAndProductVariantId(cartId, productVariantId);
    }

    @Override
    public boolean existsByCartIdAndProductVariantId(Long cartId, Long productVariantId) {
        return cartItemRepository.existsByCartIdAndProductVariantId(cartId, productVariantId);
    }
}
