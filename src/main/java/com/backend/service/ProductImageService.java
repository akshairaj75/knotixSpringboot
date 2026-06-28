package com.backend.service;

import com.backend.jewelcraft.entity.ProductImage;
import java.util.List;
import java.util.Optional;

public interface ProductImageService {

    ProductImage create(ProductImage productImage);

    ProductImage update(Long id, ProductImage productImage);

    ProductImage getById(Long id);

    List<ProductImage> getAll();

    void delete(Long id);

    List<ProductImage> getByProductId(Long productId);

    List<ProductImage> getByProductVariantId(Long productVariantId);

    Optional<ProductImage> getPrimaryByProductId(Long productId);
}
