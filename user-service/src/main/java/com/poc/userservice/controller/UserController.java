package com.poc.userservice.controller;

import com.poc.userservice.model.User;
import com.poc.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.saveUser(user);
  }

  @GetMapping
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }
}