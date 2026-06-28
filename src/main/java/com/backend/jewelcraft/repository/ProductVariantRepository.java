package com.backend.jewelcraft.repository;

import com.backend.jewelcraft.entity.ProductVariant;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long> {

    Optional<ProductVariant> findBySku(String sku);

    boolean existsBySku(String sku);

    List<ProductVariant> findByProductId(Long productId);

    List<ProductVariant> findByProductIdAndActiveTrue(Long productId);

    Optional<ProductVariant> findByProductIdAndDefaultVariantTrue(Long productId);
}
