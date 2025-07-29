package com.poc.orderservice.service.impl;

import com.poc.orderservice.client.*;
import com.poc.orderservice.dto.*;
import com.poc.orderservice.model.*;
import com.poc.orderservice.repository.*;
import com.poc.orderservice.service.*;
import java.time.*;
import java.util.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

  @Autowired
  private UserClient userClient;

  @Autowired
  private ProductClient productClient;

  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private KafkaTemplate<String, NotificationMessage> kafkaTemplate;

  @Override
  @Transactional
  public Order createOrder(CreateOrderRequest request) {
    // Fetch snapshot data
    UserSnapshot userSnapshot = userClient.getUserById(request.getUserId());
    ProductSnapshot productSnapshot = productClient.getProductById(request.getProductId());

    Order order = new Order();
    order.setUser(userSnapshot);
    order.setProduct(productSnapshot);
    order.setQuantity(request.getQuantity());
    order.setOrderDate(LocalDateTime.now(ZoneOffset.UTC));

    // Save and Notify
    Order savedOrder = orderRepository.saveAndFlush(order);
    NotificationMessage message = new NotificationMessage(savedOrder);
    log.info("Produced Kafka message to 'order-events': {}", message);
    kafkaTemplate.send("order-events", message);

    return savedOrder;
  }

  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Order getOrderById(Long id) {
    return orderRepository.findById(id).orElse(null);
  }
}