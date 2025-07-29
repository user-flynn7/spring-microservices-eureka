package com.poc.orderservice.model;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserSnapshot {

  @JsonProperty("id")
  private Long userId;
  
  private String name;
  private String email;
}