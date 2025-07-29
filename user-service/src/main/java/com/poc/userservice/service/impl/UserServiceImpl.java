package com.poc.userservice.service.impl;

import com.poc.userservice.model.User;
import com.poc.userservice.repository.UserRepository;
import com.poc.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.*;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public User saveUser(User user) {
    return userRepository.save(user);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }
}