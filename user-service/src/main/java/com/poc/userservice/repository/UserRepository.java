package com.poc.userservice.repository;

import com.poc.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.*;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}