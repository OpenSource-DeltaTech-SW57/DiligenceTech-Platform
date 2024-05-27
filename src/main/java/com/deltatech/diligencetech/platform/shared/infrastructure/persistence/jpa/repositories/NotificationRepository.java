package com.deltatech.diligencetech.platform.shared.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {
  Optional<Notification> findByNotificationId(String notificationId);
  boolean existByNotificationId(Long id);
}
