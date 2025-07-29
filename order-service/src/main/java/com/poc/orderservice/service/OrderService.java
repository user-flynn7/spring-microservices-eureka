package com.poc.orderservice.service;

import com.poc.orderservice.dto.*;
import com.poc.orderservice.model.*;
import java.util.*;

public interface OrderService {

  Order createOrder(CreateOrderRequest request);

  List<Order> getAllOrders();

  Order getOrderById(Long id);

}