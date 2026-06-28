package com.backend.jewelcraft.service;

import com.backend.jewelcraft.entity.Category;
import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category create(Category category);

    Category update(Long id, Category category);

    Category getById(Long id);

    List<Category> getAll();

    void delete(Long id);

    Optional<Category> getBySlug(String slug);

    boolean existsBySlug(String slug);

    List<Category> getRootCategories();

    List<Category> getByParentId(Long parentId);

    List<Category> getActiveCategories();
}
