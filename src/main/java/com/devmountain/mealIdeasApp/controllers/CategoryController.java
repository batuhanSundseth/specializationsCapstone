package com.devmountain.mealIdeasApp.controllers;

import com.devmountain.mealIdeasApp.dtos.CategoryDto;
import com.devmountain.mealIdeasApp.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

  @GetMapping("/{categoryId}")
  public Optional<CategoryDto> getCategory(@PathVariable Long categoryId) {
    return categoryService.getCategory(categoryId);
  }

  @GetMapping("/user/{userId}")
  public List<CategoryDto> getCategoriesByUser(@PathVariable Long userId) {
    return categoryService.getAllCategoriesByUserId(userId);
  }

  @PostMapping("/user/{userId}")
  public void addCategory(@RequestBody CategoryDto categoryDto, @PathVariable Long userId) {
    categoryService.addCategory(categoryDto, userId);
  }

  @DeleteMapping("/{categoryId}")
  public void deleteCategory(@PathVariable Long categoryId) {
    categoryService.deleteCategory(categoryId);
  }
}
