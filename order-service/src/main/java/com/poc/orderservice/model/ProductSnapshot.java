package com.poc.orderservice.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductSnapshot {

  @JsonAlias("id")
  private Long productId;

  private String name;
  private String description;
  private Double price;
}