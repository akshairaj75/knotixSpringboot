package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.ProductImage;
import com.backend.jewelcraft.repository.ProductImageRepository;
import com.backend.service.ProductImageService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;

    public ProductImageServiceImpl(ProductImageRepository productImageRepository) {
        this.productImageRepository = productImageRepository;
    }

    @Override
    public ProductImage create(ProductImage productImage) {
        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImage update(Long id, ProductImage productImage) {
        getById(id);
        productImage.setId(id);
        return productImageRepository.save(productImage);
    }

    @Override
    public ProductImage getById(Long id) {
        return productImageRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProductImage not found with id: " + id));
    }

    @Override
    public List<ProductImage> getAll() {
        return productImageRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        productImageRepository.deleteById(id);
    }

    @Override
    public List<ProductImage> getByProductId(Long productId) {
        return productImageRepository.findByProductId(productId);
    }

    @Override
    public List<ProductImage> getByProductVariantId(Long productVariantId) {
        return productImageRepository.findByProductVariantId(productVariantId);
    }

    @Override
    public Optional<ProductImage> getPrimaryByProductId(Long productId) {
        return productImageRepository.findByProductIdAndPrimaryImageTrue(productId);
    }
}
