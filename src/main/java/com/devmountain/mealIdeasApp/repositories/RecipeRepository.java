package com.devmountain.mealIdeasApp.repositories;

import com.devmountain.mealIdeasApp.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
  List<Recipe> findAll();
}
