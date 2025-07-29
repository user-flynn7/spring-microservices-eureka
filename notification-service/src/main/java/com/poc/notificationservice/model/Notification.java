package com.poc.notificationservice.model;

import jakarta.persistence.*;
import java.time.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long userId;

  private Long orderId;

  private Instant orderDate;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "productId", column = @Column(name = "product_id")),
      @AttributeOverride(name = "name", column = @Column(name = "product_name")),
      @AttributeOverride(name = "description", column = @Column(name = "product_description")),
      @AttributeOverride(name = "price", column = @Column(name = "product_price"))
  })
  private ProductSnapshot product;

  private Integer quantity;

  private Instant timestamp;
}