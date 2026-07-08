package com.backend.jewelcraft.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backend.jewelcraft.dto.productDto.ProductRequestDto;
import com.backend.jewelcraft.dto.productDto.ProductResponseDto;
import com.backend.jewelcraft.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;


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

    @GetMapping("/get-products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> res = productService.getAllProducts();
        return ResponseEntity.ok(res);
    }

    @PutMapping("/update-product/{productId}")
    public ResponseEntity<ProductResponseDto> updateProduct(
            @RequestBody ProductRequestDto product,
            @PathVariable Long productId,
            HttpServletRequest request) {
        ProductResponseDto res = productService.updateProduct(product, request, productId);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/view-product/{productId}")
    public ResponseEntity<ProductResponseDto> viewProduct(@PathVariable Long productId) {
        ProductResponseDto res = productService.getProductById(productId);
        return ResponseEntity.ok(res);
    }
    
}
