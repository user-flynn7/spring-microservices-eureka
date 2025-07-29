package com.poc.orderservice.config;

import com.poc.orderservice.dto.*;
import java.util.*;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.*;

@Configuration
public class KafkaProducerConfig {

  @Bean
  public ProducerFactory<String, NotificationMessage> producerFactory() {
    Map<String, Object> config = new HashMap<>();
    config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
    return new DefaultKafkaProducerFactory<>(config);
  }

  @Bean
  public KafkaTemplate<String, NotificationMessage> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}