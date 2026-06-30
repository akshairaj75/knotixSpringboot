package com.backend.jewelcraft.service;

import java.util.List;

import com.backend.jewelcraft.dto.categoryDto.CategoryRequestDto;
import com.backend.jewelcraft.dto.categoryDto.CategoryResponseDto;

import jakarta.servlet.http.HttpServletRequest;

public interface CategoryService {

    CategoryResponseDto createCategory(CategoryRequestDto dto, HttpServletRequest request);

    List<CategoryResponseDto> getAllCategories(HttpServletRequest request);

    // Category update(Long id, Category category);

    // Category getById(Long id);

    // List<Category> getAll();

    // void delete(Long id);

    // Optional<Category> getBySlug(String slug);

    // boolean existsBySlug(String slug);

    // List<Category> getRootCategories();

    // List<Category> getByParentId(Long parentId);

    // List<Category> getActiveCategories();
}
