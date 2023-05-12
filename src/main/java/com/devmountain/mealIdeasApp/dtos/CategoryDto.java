package com.devmountain.mealIdeasApp.dtos;

import com.devmountain.mealIdeasApp.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {
  private Long categoryId;
//  private Long userId;
  private String categoryName;
  private Set<RecipeDto> recipeDtoSet = new HashSet<>();
  private UserDto userDto;

  public CategoryDto(Category category) {
    if (category.getCategoryId() != null) {
      this.categoryId = category.getCategoryId();
    }

//    if (category.getUserId() != null) {
//      this.userId = category.getUserId();
//    }

    if (category.getCategoryName() != null) {
      this.categoryName = category.getCategoryName();
    }
  }
}
