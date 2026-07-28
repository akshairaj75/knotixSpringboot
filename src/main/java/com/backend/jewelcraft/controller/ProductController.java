package com.backend.jewelcraft.controller;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
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

    @PostMapping(value = "/add-products", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> addProduct(
            @RequestPart("product") ProductRequestDto product,
            @RequestPart(value = "image", required = false) MultipartFile image,
            HttpServletRequest request) {
        ProductResponseDto res = productService.createProduct(product, image, request);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/add-products/bulk")
    public ResponseEntity<List<ProductResponseDto>> addBulkProducts(
            @RequestBody List<ProductRequestDto> products,
            HttpServletRequest request) {
        List<ProductResponseDto> res = products.stream()
                .map(productRequestDto -> productService.createProduct(productRequestDto, null, request))
                .toList();
        return ResponseEntity.ok(res);

    }

    @GetMapping("/get-products")
    public ResponseEntity<List<ProductResponseDto>> getAllProducts() {
        List<ProductResponseDto> res = productService.getAllProducts();
        return ResponseEntity.ok(res);
    }

    @PutMapping(value = "/update-product/{productId}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ProductResponseDto> updateProduct(
            @RequestPart("product") ProductRequestDto product,
            @RequestPart(value = "image", required = false) MultipartFile image,
            @PathVariable Long productId,
            HttpServletRequest request) {
        ProductResponseDto res = productService.updateProduct(product, image, request, productId);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/view-product/{productId}")
    public ResponseEntity<ProductResponseDto> viewProduct(@PathVariable Long productId) {
        ProductResponseDto res = productService.getProductById(productId);
        return ResponseEntity.ok(res);
    }
    
}
