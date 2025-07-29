package com.poc.orderservice.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

  private Long userId;
  private Long productId;
  private Integer quantity;
}
