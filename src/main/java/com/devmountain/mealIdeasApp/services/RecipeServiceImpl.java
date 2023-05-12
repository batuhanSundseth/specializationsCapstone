package com.devmountain.mealIdeasApp.services;

import com.devmountain.mealIdeasApp.dtos.RecipeDto;
import com.devmountain.mealIdeasApp.entities.Category;
import com.devmountain.mealIdeasApp.entities.Recipe;
import com.devmountain.mealIdeasApp.repositories.CategoryRepository;
import com.devmountain.mealIdeasApp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeServiceImpl implements RecipeService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private RecipeRepository recipeRepository;

  @Override
  public Optional<RecipeDto> getRecipe(Long recipeId) {
    Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
    if (recipeOptional.isPresent()) {
      return Optional.of(new RecipeDto(recipeOptional.get()));
    }
    return Optional.empty();
  }

  @Override
  public List<RecipeDto> getAllRecipes() {
    List<Recipe> recipeList = recipeRepository.findAll();
    return recipeList.stream().map(recipe -> new RecipeDto(recipe)).collect(Collectors.toList());
  }

  @Override
  @Transactional
  public void addRecipe(RecipeDto recipeDto, Long categoryId) {
    Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
    Recipe recipe = new Recipe(recipeDto);
    categoryOptional.ifPresent(recipe::setCategory);
    recipeRepository.saveAndFlush(recipe);
  }

  @Override
  @Transactional
  public void deleteRecipe(Long recipeId) {
    Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
    recipeOptional.ifPresent(recipe -> recipeRepository.delete(recipe));
  }

  @Override
  public Optional<RecipeDto> getRandomRecipe() {
    int recipeLength = getAllRecipes().size();
    int recipeRandom = (int) (Math.random() * (recipeLength - 1) + 1);
    System.out.println(recipeRandom);
    Optional<Recipe> recipeOptional = recipeRepository.findById((long) recipeRandom);
    System.out.println(recipeOptional);
    return Optional.of(new RecipeDto(recipeOptional.get()));
  }
}
