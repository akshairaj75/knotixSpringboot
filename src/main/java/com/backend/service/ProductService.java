package com.backend.service;

import com.backend.jewelcraft.entity.Product;
import com.backend.jewelcraft.enums.ProductStatus;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product create(Product product);

    Product update(Long id, Product product);

    Product getById(Long id);

    List<Product> getAll();

    void delete(Long id);

    Optional<Product> getBySlug(String slug);

    boolean existsBySlug(String slug);

    List<Product> getByCategoryId(Long categoryId);

    List<Product> getByStatus(ProductStatus status);

    List<Product> getFeaturedProducts();
}
