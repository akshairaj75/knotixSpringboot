package com.backend.jewelcraft.service;

import com.backend.jewelcraft.entity.ProductReview;
import java.util.List;
import java.util.Optional;

public interface ProductReviewService {

    ProductReview create(ProductReview productReview);

    ProductReview update(Long id, ProductReview productReview);

    ProductReview getById(Long id);

    List<ProductReview> getAll();

    void delete(Long id);

    List<ProductReview> getByUserId(Long userId);

    List<ProductReview> getByProductId(Long productId);

    List<ProductReview> getApprovedByProductId(Long productId);

    Optional<ProductReview> getByUserIdAndProductId(Long userId, Long productId);

    boolean existsByUserIdAndProductId(Long userId, Long productId);
}
