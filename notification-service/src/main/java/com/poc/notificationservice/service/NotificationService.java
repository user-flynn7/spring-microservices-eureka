package com.poc.notificationservice.service;

import com.poc.notificationservice.dto.*;

public interface NotificationService {

  void sendNotification(NotificationMessage message);
}