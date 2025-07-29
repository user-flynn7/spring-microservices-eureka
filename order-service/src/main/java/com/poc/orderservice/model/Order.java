package com.poc.orderservice.model;

import jakarta.persistence.*;
import java.time.*;
import lombok.*;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer quantity;
  private LocalDateTime orderDate;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "userId", column = @Column(name = "user_id")),
      @AttributeOverride(name = "name", column = @Column(name = "user_name")),
      @AttributeOverride(name = "email", column = @Column(name = "user_email"))
  })
  private UserSnapshot user;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "productId", column = @Column(name = "product_id")),
      @AttributeOverride(name = "name", column = @Column(name = "product_name")),
      @AttributeOverride(name = "description", column = @Column(name = "product_description")),
      @AttributeOverride(name = "price", column = @Column(name = "product_price"))
  })
  private ProductSnapshot product;
}