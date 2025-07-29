package com.poc.productservice.repository;

import com.poc.productservice.model.*;
import org.springframework.data.jpa.repository.*;

public interface ProductRepository extends JpaRepository<Product, Long> {

}