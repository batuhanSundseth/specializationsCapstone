package com.devmountain.mealIdeasApp.dtos;

import com.devmountain.mealIdeasApp.entities.Recipe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDto implements Serializable {
  private Long recipeId;
//  private Long categoryId;
  private String recipeName;
  private CategoryDto categoryDto;

  public RecipeDto(Recipe recipe) {
    if (recipe.getRecipeId() != null) {
      this.recipeId = recipe.getRecipeId();
    }

//    if (recipe.getCategoryId() != null) {
//      this.categoryId = recipe.getCategoryId();
//    }

    if (recipe.getRecipeName() != null) {
      this.recipeName = recipe.getRecipeName();
    }
  }
}
