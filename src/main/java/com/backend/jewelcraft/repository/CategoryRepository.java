package com.backend.jewelcraft.repository;

import com.backend.jewelcraft.entity.Category;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<Category> findByParentIsNull();

    List<Category> findByParentId(Long parentId);

    List<Category> findByActive(boolean active);
}
