package com.devmountain.mealIdeasApp.repositories;

import com.devmountain.mealIdeasApp.entities.Category;
import com.devmountain.mealIdeasApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findAllByUserEquals(User user);
}
