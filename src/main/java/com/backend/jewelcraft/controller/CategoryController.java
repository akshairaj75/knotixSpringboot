package com.backend.jewelcraft.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.jewelcraft.dto.categoryDto.CategoryRequestDto;
import com.backend.jewelcraft.dto.categoryDto.CategoryResponseDto;
import com.backend.jewelcraft.service.CategoryService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add-category")
    public ResponseEntity<CategoryResponseDto> createCategory(
            @RequestBody CategoryRequestDto dto,
            HttpServletRequest request) {
        CategoryResponseDto res = categoryService.createCategory(dto, request);
        return ResponseEntity.ok(res);
    }

    @PostMapping("/add-category/bulk")
    public ResponseEntity<List<CategoryResponseDto>> createBulkCategories(
            @RequestBody List<CategoryRequestDto> dto,
            HttpServletRequest request) {
        List<CategoryResponseDto> res = dto.stream()
                .map(categoryRequestDto -> categoryService.createCategory(categoryRequestDto, request))
                .toList();
        return ResponseEntity.ok(res);
    }

    @GetMapping("/get-categories")
    public ResponseEntity<List<CategoryResponseDto>> getAllCategories(HttpServletRequest request) {
        List<CategoryResponseDto> res = categoryService.getAllCategories(request);
        return ResponseEntity.ok(res);
    }

}
