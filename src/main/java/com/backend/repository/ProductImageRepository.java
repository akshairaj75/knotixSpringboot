package com.backend.jewelcraft.repository;

import com.backend.jewelcraft.entity.ProductImage;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {

    List<ProductImage> findByProductId(Long productId);

    List<ProductImage> findByProductVariantId(Long productVariantId);

    Optional<ProductImage> findByProductIdAndPrimaryImageTrue(Long productId);
}
