package com.devmountain.mealIdeasApp.services;

import com.devmountain.mealIdeasApp.dtos.UserDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {
  @Transactional
  List<String> addUser(UserDto userDto);

  List<String> userLogin(UserDto userDto);
}
