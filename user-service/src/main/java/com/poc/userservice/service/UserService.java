package com.poc.userservice.service;

import com.poc.userservice.model.User;
import java.util.List;

public interface UserService {
  User saveUser(User user);

  List<User> getAllUsers();

  User getUserById(Long id);
}