package com.backend.jewelcraft.serviceImpl;

import org.springframework.web.multipart.MultipartFile;
import com.backend.jewelcraft.dto.productDto.ProductRequestDto;
import com.backend.jewelcraft.dto.productDto.ProductResponseDto;
import com.backend.jewelcraft.entity.Category;
import com.backend.jewelcraft.entity.Product;
import com.backend.jewelcraft.entity.ProductImage;
import com.backend.jewelcraft.entity.ProductVariant;
import com.backend.jewelcraft.repository.CategoryRepository;
import com.backend.jewelcraft.repository.ProductImageRepository;
import com.backend.jewelcraft.repository.ProductRepository;
import com.backend.jewelcraft.repository.ProductVariantRepository;
import com.backend.jewelcraft.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    final ProductRepository productRepository;

    final CategoryRepository CategoryRepository;

    final ProductImageRepository imageRepository;

    final ProductVariantRepository productVariantRepository;

    final com.backend.jewelcraft.repository.UserRepository userRepository;

    final FileStorageService fileStorageService;

    ProductServiceImpl(ProductRepository productRepository, CategoryRepository CategoryRepository,
        ProductImageRepository imageRepository, ProductVariantRepository productVariantRepository, 
        com.backend.jewelcraft.repository.UserRepository userRepository, FileStorageService fileStorageService) {
        this.productRepository = productRepository;
        this.CategoryRepository = CategoryRepository;
        this.imageRepository = imageRepository;
        this.productVariantRepository = productVariantRepository;
        this.userRepository = userRepository;
        this.fileStorageService = fileStorageService;
    }

    private void checkAdminPermission(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Access denied: Unauthorized access. Please log in.");
        }
        
        String token = authHeader.substring(7).trim();
        
        // Mock token for developer and manual test ease
        if ("admin-token".equalsIgnoreCase(token)) {
            return;
        }
        
        com.backend.jewelcraft.entity.User user = userRepository.findByEmail(token)
                .orElseThrow(() -> new RuntimeException("Access denied: Invalid session or user not found."));
                
        if (user.getRole() != com.backend.jewelcraft.enums.UserRole.ADMIN) {
            throw new RuntimeException("Access denied: Only administrator accounts can perform this action.");
        }
    }

    @Transactional
    @Override
    public ProductResponseDto createProduct(ProductRequestDto dto, MultipartFile image, HttpServletRequest request) {
        checkAdminPermission(request);
        Category category = CategoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("No category found for you request"));

        Product product = new Product();
        product.setName(dto.getName());
        
        String slug = dto.getSlug() != null && !dto.getSlug().isEmpty() 
                ? dto.getSlug() 
                : dto.getName().toLowerCase().replaceAll("[^a-z0-9]+", "-");
        product.setSlug(slug);
        product.setSku(dto.getSku());
        
        product.setStatus(dto.getStatus() != null ? dto.getStatus() : com.backend.jewelcraft.enums.ProductStatus.ACTIVE);
        product.setDescription(dto.getDescription());
        product.setShortDescription(dto.getDescription() != null && dto.getDescription().length() > 100 
                ? dto.getDescription().substring(0, 97) + "..." 
                : dto.getDescription());
        product.setBasePrice(dto.getBasePrice());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        if (image != null && !image.isEmpty()) {
            try {
                String imageUrl = fileStorageService.storeFile(image, "products");
                ProductImage productImage = new ProductImage();
                productImage.setProduct(savedProduct);
                productImage.setImageUrl(imageUrl);
                productImage.setAltText("image");
                productImage.setPrimaryImage(true);
                imageRepository.save(productImage);
            } catch (java.io.IOException e) {
                throw new RuntimeException("Failed to store image", e);
            }
        }

        ProductVariant variant = new ProductVariant();
        variant.setProduct(savedProduct);
        variant.setSku(dto.getSku() != null && !dto.getSku().isEmpty() ? dto.getSku() : slug + "-default");
        variant.setVariantName("Default");
        variant.setPrice(dto.getBasePrice());
        variant.setStockQuantity(dto.getStock() != null ? dto.getStock() : 10);
        variant.setDefaultVariant(true);
        variant.setActive(true);
        productVariantRepository.save(variant);

        return ProductResponseDto.fromEntity(savedProduct);

    }

    @Override
    public List<ProductResponseDto> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductResponseDto::fromEntity)
                .toList();
    }

    @Transactional
    @Override
    public ProductResponseDto updateProduct(ProductRequestDto dto, MultipartFile image, HttpServletRequest request, Long productId) {
        checkAdminPermission(request);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("No product found for your request"));

        Category category = CategoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("No category found for your request"));

        product.setName(dto.getName());
        String slug = dto.getSlug() != null && !dto.getSlug().isEmpty() 
                ? dto.getSlug() 
                : dto.getName().toLowerCase().replaceAll("[^a-z0-9]+", "-");
        product.setSlug(slug);
        product.setSku(dto.getSku());
        
        product.setStatus(dto.getStatus() != null ? dto.getStatus() : product.getStatus());
        product.setDescription(dto.getDescription());
        product.setShortDescription(dto.getDescription() != null && dto.getDescription().length() > 100 
                ? dto.getDescription().substring(0, 97) + "..." 
                : dto.getDescription());
        product.setBasePrice(dto.getBasePrice());
        product.setCategory(category);

        Product savedProduct = productRepository.save(product);

        if (image != null && !image.isEmpty()) {
            try {
                String imageUrl = fileStorageService.storeFile(image, "products");
                java.util.Optional<ProductImage> existingPrimaryOpt = imageRepository.findByProductIdAndPrimaryImageTrue(productId);
                if (existingPrimaryOpt.isPresent()) {
                    ProductImage existingPrimary = existingPrimaryOpt.get();
                    // fileStorageService.deleteFile(existingPrimary.getImageUrl(), "products");
                    existingPrimary.setImageUrl(imageUrl);
                    imageRepository.save(existingPrimary);
                } else {
                    ProductImage productImage = new ProductImage();
                    productImage.setProduct(savedProduct);
                    productImage.setImageUrl(imageUrl);
                    productImage.setAltText("image");
                    productImage.setPrimaryImage(true);
                    imageRepository.save(productImage);
                }
            } catch (java.io.IOException e) {
                throw new RuntimeException("Failed to store image", e);
            }
        }

        ProductVariant variant = productVariantRepository
                .findByProductIdAndDefaultVariantTrue(savedProduct.getId())
                .orElse(null);
        if (variant == null) {
            variant = new ProductVariant();
            variant.setProduct(savedProduct);
            variant.setSku(dto.getSku() != null && !dto.getSku().isEmpty() ? dto.getSku() : slug + "-default");
            variant.setVariantName("Default");
            variant.setDefaultVariant(true);
            variant.setActive(true);
        } else {
            if (dto.getSku() != null && !dto.getSku().isEmpty()) {
                variant.setSku(dto.getSku());
            }
        }
        variant.setPrice(dto.getBasePrice());
        if (dto.getStock() != null) {
            variant.setStockQuantity(dto.getStock());
        }
        productVariantRepository.save(variant);

        return ProductResponseDto.fromEntity(savedProduct);
    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("No product found for your request"));
        return ProductResponseDto.fromEntity(product);
    }

}