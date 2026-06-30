package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.dto.productDto.ProductImageRequestDto;
import com.backend.jewelcraft.dto.productDto.ProductRequestDto;
import com.backend.jewelcraft.dto.productDto.ProductResponseDto;
import com.backend.jewelcraft.entity.Category;
import com.backend.jewelcraft.entity.Product;
import com.backend.jewelcraft.entity.ProductImage;
import com.backend.jewelcraft.repository.CategoryRepository;
import com.backend.jewelcraft.repository.ProductImageRepository;
import com.backend.jewelcraft.repository.ProductRepository;
import com.backend.jewelcraft.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categorytRepository;

    @Autowired
    ProductImageRepository imageRepository;

    @Transactional
    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto, HttpServletRequest request) {
        Category category = categorytRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("No category found for you request"));

        Product product = new Product();
        product.setName(dto.getName());
        product.setSlug(dto.getSlug());
        product.setStatus(dto.getStatus());
        product.setDescription(dto.getDescription());
        product.setBasePrice(dto.getBasePrice());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        if (dto.getImageUrl() != null) {
            ProductImage image = new ProductImage();
            image.setProduct(savedProduct);
            image.setImageUrl(dto.getImageUrl());
            image.setAltText("image");
            imageRepository.save(image);
        }

        return ProductResponseDto.fromEntity(savedProduct);

    }

}
