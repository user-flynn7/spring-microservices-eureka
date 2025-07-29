package com.poc.productservice.service.impl;

import com.poc.productservice.model.*;
import com.poc.productservice.repository.*;
import com.poc.productservice.service.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Service
public class ProductServiceImpl implements ProductService {

  @Autowired
  private ProductRepository productRepository;

  @Override
  @Transactional
  public Product createProduct(Product product) {
    return productRepository.save(product);
  }

  @Override
  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Product getProductById(Long id) {
    return productRepository.findById(id).orElse(null);
  }
}