package com.poc.notificationservice.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductSnapshot {

  private Long productId;
  private String name;
  private String description;
  private Double price;
}
