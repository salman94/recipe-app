package com.codeknight.recipeapp.repositories;

import com.codeknight.recipeapp.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByDescription(String description);
}
