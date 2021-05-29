package com.codeknight.recipeapp.repositories;

import com.codeknight.recipeapp.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
