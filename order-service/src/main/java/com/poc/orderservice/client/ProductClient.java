package com.poc.orderservice.client;

import com.poc.orderservice.model.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product-service")
public interface ProductClient {

  @GetMapping("/api/products/{id}")
  ProductSnapshot getProductById(@PathVariable("id") Long id);
}