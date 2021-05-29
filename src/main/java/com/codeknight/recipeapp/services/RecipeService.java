package com.codeknight.recipeapp.services;

import com.codeknight.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
