package com.poc.productservice.controller;

import com.poc.productservice.model.*;
import com.poc.productservice.service.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductController {

  @Autowired
  private ProductService productService;

  @PostMapping
  public Product create(@RequestBody Product product) {
    return productService.createProduct(product);
  }

  @GetMapping
  public List<Product> getAll() {
    return productService.getAllProducts();
  }

  @GetMapping("/{id}")
  public Product getById(@PathVariable Long id) {
    return productService.getProductById(id);
  }
}