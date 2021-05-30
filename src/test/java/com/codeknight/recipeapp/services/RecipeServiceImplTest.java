package com.codeknight.recipeapp.services;

import com.codeknight.recipeapp.domain.Recipe;
import com.codeknight.recipeapp.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RecipeServiceImplTest {

    private RecipeService recipeService;

    @Mock
    private RecipeRepository recipeRepository;

    @BeforeEach
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception {
        List<Recipe> recipes = new ArrayList<>();
        Recipe recipe = new Recipe();
        recipes.add(recipe);
        Set<Recipe> recipeSet = new HashSet<>(recipes);
        Mockito.when(recipeRepository.findAll()).thenReturn(recipes);
        assertEquals(recipeSet, recipeService.getRecipes());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }

    @Test
    void getRecipeById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Mockito.when(recipeRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(recipe));
        assertEquals(recipe, recipeService.getRecipeById(1L));
        Mockito.verify(recipeRepository, Mockito.times(1)).findById(ArgumentMatchers.anyLong());
    }
}
