package com.poc.notificationservice.service.impl;

import com.poc.notificationservice.dto.*;
import com.poc.notificationservice.model.*;
import com.poc.notificationservice.repository.*;
import com.poc.notificationservice.service.*;
import java.time.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

  private final NotificationRepository repository;

  @Override
  public void sendNotification(NotificationMessage message) {
    Notification notification = Notification.builder()
        .userId(message.getUserId())
        .orderId(message.getOrderId())
        .orderDate(message.getOrderDate().toInstant(ZoneOffset.UTC))
        .product(message.getProduct())
        .quantity(message.getQuantity())
        .timestamp(Instant.now())
        .build();

    repository.saveAndFlush(notification);
  }
}