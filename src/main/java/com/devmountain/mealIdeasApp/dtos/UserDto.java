package com.devmountain.mealIdeasApp.dtos;

import com.devmountain.mealIdeasApp.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
  private Long userId;
  private String username;
  private String password;
  private Set<CategoryDto> categoryDtoSet = new HashSet<>();

  public UserDto(User user) {
    if (user.getUserId() != null) {
      this.userId = user.getUserId();
    }

    if (user.getUsername() != null) {
      this.username = user.getUsername();
    }

    if (user.getPassword() != null) {
      this.password = user.getPassword();
    }
  }
}
