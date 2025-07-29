package com.poc.orderservice.repository;

import com.poc.orderservice.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}