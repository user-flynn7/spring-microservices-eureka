package com.poc.orderservice.dto;

import com.poc.orderservice.model.*;
import java.time.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationMessage {

  private LocalDateTime orderDate;
  private Long orderId;
  private Long userId;
  private ProductSnapshot product;
  private Integer quantity;

  public NotificationMessage(Order order) {
    this.orderDate = order.getOrderDate();
    this.orderId = order.getId();
    this.product = order.getProduct();
    this.userId = order.getUser().getUserId();
    this.quantity = order.getQuantity();
  }
}