package com.devmountain.mealIdeasApp.entities;

import com.devmountain.mealIdeasApp.dtos.RecipeDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
  public Recipe(RecipeDto recipeDto) {
    if (recipeDto.getRecipeName() != null) {
      this.recipeName = recipeDto.getRecipeName();
    }
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long recipeId;

  @Column
  private String recipeName;

//  @Column
//  private Long categoryId;

  @JsonBackReference
  @ManyToOne
  private Category category;

//  public Long getCategoryId() {
//    return categoryId;
//  }
//
//  public void setCategoryId(Long categoryId) {
//    this.categoryId = categoryId;
//  }

  public Long getRecipeId() {
    return recipeId;
  }

  public void setRecipeId(Long recipeId) {
    this.recipeId = recipeId;
  }

  public String getRecipeName() {
    return recipeName;
  }

  public void setRecipeName(String recipeName) {
    this.recipeName = recipeName;
  }
}
