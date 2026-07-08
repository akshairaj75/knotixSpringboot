package com.backend.jewelcraft.service;

import java.util.List;

import com.backend.jewelcraft.dto.productDto.ProductRequestDto;
import com.backend.jewelcraft.dto.productDto.ProductResponseDto;

import jakarta.servlet.http.HttpServletRequest;


public interface ProductService {

    // Product create(ProductRequestDto product);

	ProductResponseDto createProduct(ProductRequestDto product, HttpServletRequest request);

    List<ProductResponseDto> getAllProducts();

    ProductResponseDto updateProduct(ProductRequestDto product, HttpServletRequest request, Long productId);

    ProductResponseDto getProductById(Long productId);

    // Product update(Long id, Product product);

    // Product getById(Long id);

    // List<Product> getAll();

    // void delete(Long id);

    // Optional<Product> getBySlug(String slug);

    // boolean existsBySlug(String slug);

    // List<Product> getByCategoryId(Long categoryId);

    // List<Product> getByStatus(ProductStatus status);

    // List<Product> getFeaturedProducts();

    //============================================
}
