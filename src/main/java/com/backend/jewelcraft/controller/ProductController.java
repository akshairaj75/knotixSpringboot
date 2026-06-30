package com.backend.jewelcraft.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.jewelcraft.dto.productDto.ProductRequestDto;
import com.backend.jewelcraft.dto.productDto.ProductResponseDto;
import com.backend.jewelcraft.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/add-products")
    public ResponseEntity<ProductResponseDto> addProduct(
            @RequestBody ProductRequestDto product,
            HttpServletRequest request) {
        ProductResponseDto res = productService.createProduct(product, request);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/add-products/bulk")
    public ResponseEntity<List<ProductResponseDto>> addBulkProducts(
            @RequestBody List<ProductRequestDto> products,
            HttpServletRequest request) {
        List<ProductResponseDto> res = products.stream()
                .map(ProductRequestDto -> productService.createProduct(ProductRequestDto, request))
                .toList();
        return ResponseEntity.ok(res);

    }

    @GetMapping
    public String getAllProducts() {
        return "All products";
    }
}
