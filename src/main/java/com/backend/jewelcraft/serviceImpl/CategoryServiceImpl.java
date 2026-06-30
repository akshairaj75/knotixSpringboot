package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.dto.categoryDto.CategoryRequestDto;
import com.backend.jewelcraft.dto.categoryDto.CategoryResponseDto;
import com.backend.jewelcraft.entity.Category;
import com.backend.jewelcraft.repository.CategoryRepository;
import com.backend.jewelcraft.service.CategoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Transactional
    @Override
    public CategoryResponseDto createCategory(CategoryRequestDto dto, HttpServletRequest request) {

        Category category = new Category();

        Category parentCategory = null;

        if (dto.getParentId() != null) {
            parentCategory = categoryRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));

            category.setParent(parentCategory);
        }

        category.setName(dto.getName());
        category.setSlug(dto.getSlug());
        category.setDescription(dto.getDescription());        category.setActive(true);

        Category savedCategory = categoryRepository.save(category);

        return CategoryResponseDto.fromEntity(savedCategory);
    }

    @Override
    public List<CategoryResponseDto> getAllCategories(HttpServletRequest request) {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream()
                .map(CategoryResponseDto::fromEntity)
                .toList();
    }

}
