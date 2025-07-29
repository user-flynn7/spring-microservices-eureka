package com.poc.orderservice.controller;

import com.poc.orderservice.dto.*;
import com.poc.orderservice.model.*;
import com.poc.orderservice.service.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

  @Autowired
  private OrderService orderService;

  @PostMapping
  public Order createOrder(@RequestBody CreateOrderRequest request) {
    return orderService.createOrder(request);
  }

  @GetMapping
  public List<Order> getAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("/{id}")
  public Order getOrderById(@PathVariable Long id) {
    return orderService.getOrderById(id);
  }
}