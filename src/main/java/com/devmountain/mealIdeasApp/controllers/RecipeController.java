package com.devmountain.mealIdeasApp.controllers;

import com.devmountain.mealIdeasApp.dtos.RecipeDto;
import com.devmountain.mealIdeasApp.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
  @Autowired
  private RecipeService recipeService;

  @GetMapping("/{recipeId}")
  public Optional<RecipeDto> getRecipe(@PathVariable Long recipeId) {
    return recipeService.getRecipe(recipeId);
  }

  @GetMapping("/")
  public List<RecipeDto> getAllRecipes() {
    return recipeService.getAllRecipes();
  }

  @GetMapping("/random")
  public Optional<RecipeDto> getRandomRecipe() {
    return recipeService.getRandomRecipe();
  }

  @PostMapping("/category/{categoryId}")
  public void addRecipe(@RequestBody RecipeDto recipeDto, @PathVariable Long categoryId) {
    recipeService.addRecipe(recipeDto, categoryId);
  }

  @DeleteMapping("/{recipeId}")
  public void deleteRecipe(@PathVariable Long recipeId) {
    recipeService.deleteRecipe(recipeId);
  }
}
