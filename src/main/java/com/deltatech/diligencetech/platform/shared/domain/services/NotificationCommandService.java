package com.deltatech.diligencetech.platform.shared.domain.services;

import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.shared.domain.model.commands.CreateNotificationCommand;

import java.util.Optional;

public interface NotificationCommandService {
  Optional<Notification> handle (CreateNotificationCommand command);
}
