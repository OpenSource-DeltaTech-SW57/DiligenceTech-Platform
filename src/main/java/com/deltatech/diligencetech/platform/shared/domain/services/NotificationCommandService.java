package com.deltatech.diligencetech.platform.duediligence.domain.services;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateNotificationCommand;

import java.util.Optional;

public interface NotificationCommandService {
  Optional<Notification> handle (CreateNotificationCommand command);
}
