package com.poc.notificationservice.dto;

import com.poc.notificationservice.model.*;
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
}