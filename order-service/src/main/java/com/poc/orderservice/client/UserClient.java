package com.poc.orderservice.client;

import com.poc.orderservice.model.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user-service")
public interface UserClient {

  @GetMapping("/api/users/{id}")
  UserSnapshot getUserById(@PathVariable("id") Long id);
}
