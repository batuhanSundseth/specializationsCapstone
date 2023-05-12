package com.devmountain.mealIdeasApp.services;

import com.devmountain.mealIdeasApp.dtos.CategoryDto;
import com.devmountain.mealIdeasApp.entities.Category;
import com.devmountain.mealIdeasApp.entities.User;
import com.devmountain.mealIdeasApp.repositories.CategoryRepository;
import com.devmountain.mealIdeasApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Optional<CategoryDto> getCategory(Long categoryId) {
    Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
    if (categoryOptional.isPresent()) {
      return Optional.of(new CategoryDto(categoryOptional.get()));
    }
    return Optional.empty();
  }

  @Override
  public List<CategoryDto> getAllCategoriesByUserId(Long userId) {
    Optional<User> userOptional = userRepository.findById(userId);
    if (userOptional.isPresent()) {
      List<Category> categoryList = categoryRepository.findAllByUserEquals(userOptional.get());
      return categoryList.stream().map(category -> new CategoryDto(category)).collect(Collectors.toList());
    }
    return Collections.emptyList();
  }

  @Override
  @Transactional
  public void addCategory(CategoryDto categoryDto, Long userId) {
    Optional<User> userOptional = userRepository.findById(userId);
    Category category = new Category(categoryDto);
    userOptional.ifPresent(category::setUser);
    categoryRepository.saveAndFlush(category);
  }

  @Override
  @Transactional
  public void deleteCategory(Long categoryId) {
    Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
    categoryOptional.ifPresent(category -> categoryRepository.delete(category));
  }
}