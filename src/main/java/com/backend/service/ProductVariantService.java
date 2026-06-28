package com.backend.service;

import com.backend.jewelcraft.entity.ProductVariant;
import java.util.List;
import java.util.Optional;

public interface ProductVariantService {

    ProductVariant create(ProductVariant productVariant);

    ProductVariant update(Long id, ProductVariant productVariant);

    ProductVariant getById(Long id);

    List<ProductVariant> getAll();

    void delete(Long id);

    Optional<ProductVariant> getBySku(String sku);

    boolean existsBySku(String sku);

    List<ProductVariant> getByProductId(Long productId);

    List<ProductVariant> getActiveByProductId(Long productId);

    Optional<ProductVariant> getDefaultByProductId(Long productId);
}
