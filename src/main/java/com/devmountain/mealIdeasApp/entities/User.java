package com.devmountain.mealIdeasApp.entities;

import com.devmountain.mealIdeasApp.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  public User(UserDto userDto) {
    if (userDto.getUsername() != null) {
      this.username = userDto.getUsername();
    }

    if (userDto.getPassword() != null) {
      this.password = userDto.getPassword();
    }
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long userId;

  @Column(unique = true)
  private String username;

  @Column
  private String password;

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
  @JsonManagedReference
  private Set<Category> categorySet = new HashSet<>();

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }
}
