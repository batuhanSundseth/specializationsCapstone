package com.devmountain.mealIdeasApp.entities;

import com.devmountain.mealIdeasApp.dtos.CategoryDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
  public Category(CategoryDto categoryDto) {
    if (categoryDto.getCategoryName() != null) {
      this.categoryName = categoryDto.getCategoryName();
    }
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryId;

  @Column
  private String categoryName;

//  @Column
//  private Long userId;

  @JsonBackReference
  @ManyToOne
  private User user;

  @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JsonManagedReference
  private Set<Recipe> recipeSet = new HashSet<>();

  public Long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Long categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

//  public Long getUserId() {
//    return userId;
//  }
//
//  public void setUserId(Long userId) {
//    this.userId = userId;
//  }
}
