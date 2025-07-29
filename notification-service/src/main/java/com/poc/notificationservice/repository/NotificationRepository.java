package com.poc.notificationservice.repository;

import com.poc.notificationservice.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}