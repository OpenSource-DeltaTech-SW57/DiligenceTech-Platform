package com.deltatech.diligencetech.platform.shared.application.internal.commandservices;

import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.shared.domain.model.commands.CreateNotificationCommand;
import com.deltatech.diligencetech.platform.shared.domain.services.NotificationCommandService;
import com.deltatech.diligencetech.platform.shared.infrastructure.persistence.jpa.repositories.NotificationRepository;

import java.util.Optional;

public class NotificationCommandServiceImpl implements NotificationCommandService {
  private final NotificationRepository notificationRepository;
  
    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }
  
  @Override
  public Optional<Notification> handle(CreateNotificationCommand command) {
      if(notificationRepository.existByNotificationId(Long.valueOf(command.id()))){
        throw new IllegalArgumentException("Notification with id " + command.id() + " already exists");
      }

    var notification = new Notification(command);
    var createdNotification = notificationRepository.save(notification);
    return Optional.of(createdNotification);
  }
  
  
}
