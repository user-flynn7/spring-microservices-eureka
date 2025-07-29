package com.poc.notificationservice.consumer;

import com.poc.notificationservice.dto.*;
import com.poc.notificationservice.service.*;
import lombok.extern.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.stereotype.*;

@Slf4j
@Service
public class NotificationConsumer {

  @Autowired
  private NotificationService notificationService;

  @KafkaListener(
      topics = "order-events",
      groupId = "notification-group",
      containerFactory = "kafkaListenerContainerFactory"
  )
  public void consume(NotificationMessage message) {
    log.info("Received Kafka message: {}", message);
    notificationService.sendNotification(message);
  }
}