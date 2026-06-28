package com.backend.jewelcraft.repository;

import com.backend.jewelcraft.entity.ProductReview;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductReviewRepository extends JpaRepository<ProductReview, Long> {

    List<ProductReview> findByUserId(Long userId);

    List<ProductReview> findByProductId(Long productId);

    List<ProductReview> findByProductIdAndApprovedTrue(Long productId);

    Optional<ProductReview> findByUserIdAndProductId(Long userId, Long productId);

    boolean existsByUserIdAndProductId(Long userId, Long productId);
}
