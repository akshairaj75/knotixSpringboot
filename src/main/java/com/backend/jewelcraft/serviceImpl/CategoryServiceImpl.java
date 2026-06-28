package com.backend.jewelcraft.serviceImpl;

import com.backend.jewelcraft.entity.Category;
import com.backend.jewelcraft.repository.CategoryRepository;
import com.backend.jewelcraft.service.CategoryService;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        getById(id);
        category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found with id: " + id));
    }

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        getById(id);
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> getBySlug(String slug) {
        return categoryRepository.findBySlug(slug);
    }

    @Override
    public boolean existsBySlug(String slug) {
        return categoryRepository.existsBySlug(slug);
    }

    @Override
    public List<Category> getRootCategories() {
        return categoryRepository.findByParentIsNull();
    }

    @Override
    public List<Category> getByParentId(Long parentId) {
        return categoryRepository.findByParentId(parentId);
    }

    @Override
    public List<Category> getActiveCategories() {
        return categoryRepository.findByActive(true);
    }
}
