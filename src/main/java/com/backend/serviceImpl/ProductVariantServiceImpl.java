package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.ProductVariant;
import com.backend.jewelcraft.repository.ProductVariantRepository;
import com.backend.service.ProductVariantService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository productVariantRepository;

    public ProductVariantServiceImpl(ProductVariantRepository productVariantRepository) {
        this.productVariantRepository = productVariantRepository;
    }

    @Override
    public ProductVariant create(ProductVariant productVariant) {
        return productVariantRepository.save(productVariant);
    }

    @Override
    public ProductVariant update(Long id, ProductVariant productVariant) {
        getById(id);
        productVariant.setId(id);
        return productVariantRepository.save(productVariant);
    }

    @Override
    public ProductVariant getById(Long id) {
        return productVariantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProductVariant not found with id: " + id));
    }

    @Override
    public List<ProductVariant> getAll() {
        return productVariantRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        productVariantRepository.deleteById(id);
    }

    @Override
    public Optional<ProductVariant> getBySku(String sku) {
        return productVariantRepository.findBySku(sku);
    }

    @Override
    public boolean existsBySku(String sku) {
        return productVariantRepository.existsBySku(sku);
    }

    @Override
    public List<ProductVariant> getByProductId(Long productId) {
        return productVariantRepository.findByProductId(productId);
    }

    @Override
    public List<ProductVariant> getActiveByProductId(Long productId) {
        return productVariantRepository.findByProductIdAndActiveTrue(productId);
    }

    @Override
    public Optional<ProductVariant> getDefaultByProductId(Long productId) {
        return productVariantRepository.findByProductIdAndDefaultVariantTrue(productId);
    }
}
