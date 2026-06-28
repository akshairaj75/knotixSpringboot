package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.ProductReview;
import com.backend.jewelcraft.repository.ProductReviewRepository;
import com.backend.service.ProductReviewService;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {

    private final ProductReviewRepository productReviewRepository;

    public ProductReviewServiceImpl(ProductReviewRepository productReviewRepository) {
        this.productReviewRepository = productReviewRepository;
    }

    @Override
    public ProductReview create(ProductReview productReview) {
        return productReviewRepository.save(productReview);
    }

    @Override
    public ProductReview update(Long id, ProductReview productReview) {
        getById(id);
        productReview.setId(id);
        return productReviewRepository.save(productReview);
    }

    @Override
    public ProductReview getById(Long id) {
        return productReviewRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ProductReview not found with id: " + id));
    }

    @Override
    public List<ProductReview> getAll() {
        return productReviewRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        productReviewRepository.deleteById(id);
    }

    @Override
    public List<ProductReview> getByUserId(Long userId) {
        return productReviewRepository.findByUserId(userId);
    }

    @Override
    public List<ProductReview> getByProductId(Long productId) {
        return productReviewRepository.findByProductId(productId);
    }

    @Override
    public List<ProductReview> getApprovedByProductId(Long productId) {
        return productReviewRepository.findByProductIdAndApprovedTrue(productId);
    }

    @Override
    public Optional<ProductReview> getByUserIdAndProductId(Long userId, Long productId) {
        return productReviewRepository.findByUserIdAndProductId(userId, productId);
    }

    @Override
    public boolean existsByUserIdAndProductId(Long userId, Long productId) {
        return productReviewRepository.existsByUserIdAndProductId(userId, productId);
    }
}
