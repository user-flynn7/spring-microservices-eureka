package com.poc.productservice.service;

import com.poc.productservice.model.*;
import java.util.*;

public interface ProductService {

  Product createProduct(Product product);

  List<Product> getAllProducts();

  Product getProductById(Long id);
}