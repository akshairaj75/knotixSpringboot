package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.Product;
import com.backend.jewelcraft.enums.ProductStatus;
import com.backend.jewelcraft.repository.ProductRepository;
import com.backend.jewelcraft.service.ProductService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product product) {
        getById(id);
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> getBySlug(String slug) {
        return productRepository.findBySlug(slug);
    }

    @Override
    public boolean existsBySlug(String slug) {
        return productRepository.existsBySlug(slug);
    }

    @Override
    public List<Product> getByCategoryId(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Product> getByStatus(ProductStatus status) {
        return productRepository.findByStatus(status);
    }

    @Override
    public List<Product> getFeaturedProducts() {
        return productRepository.findByFeaturedTrue();
    }
}
