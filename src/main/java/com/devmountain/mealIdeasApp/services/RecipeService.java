package com.devmountain.mealIdeasApp.services;

import com.devmountain.mealIdeasApp.dtos.RecipeDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RecipeService {
  Optional<RecipeDto> getRecipe(Long recipeId);

  List<RecipeDto> getAllRecipes();

  @Transactional
  void addRecipe(RecipeDto recipeDto, Long categoryId);

  @Transactional
  void deleteRecipe(Long recipeId);

  Optional<RecipeDto> getRandomRecipe();
}
