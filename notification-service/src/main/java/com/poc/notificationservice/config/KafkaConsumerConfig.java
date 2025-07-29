package com.poc.notificationservice.config;

import com.poc.notificationservice.dto.*;
import java.util.*;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.kafka.config.*;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.*;

@EnableKafka
@Configuration
public class KafkaConsumerConfig {

  @Bean
  public ConsumerFactory<String, NotificationMessage> consumerFactory() {
    JsonDeserializer<NotificationMessage> deserializer = new JsonDeserializer<>(
        NotificationMessage.class);
    deserializer.setRemoveTypeHeaders(false);
    deserializer.addTrustedPackages("*");
    deserializer.setUseTypeMapperForKey(true);

    Map<String, Object> config = new HashMap<>();
    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    config.put(ConsumerConfig.GROUP_ID_CONFIG, "notification-group");
    config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
    config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

    return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), deserializer);
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, NotificationMessage> kafkaListenerContainerFactory() {
    ConcurrentKafkaListenerContainerFactory<String, NotificationMessage> factory =
        new ConcurrentKafkaListenerContainerFactory<>();
    factory.setConsumerFactory(consumerFactory());
    return factory;
  }
}