package com.devmountain.mealIdeasApp.services;

import com.devmountain.mealIdeasApp.dtos.CategoryDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
  Optional<CategoryDto> getCategory(Long categoryId);

  List<CategoryDto> getAllCategoriesByUserId(Long userId);

  @Transactional
  void addCategory(CategoryDto categoryDto, Long userId);

  @Transactional
  void deleteCategory(Long categoryId);
}
