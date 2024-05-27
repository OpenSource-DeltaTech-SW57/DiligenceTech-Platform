package com.deltatech.diligencetech.platform.shared.application.internal.queryservices;


import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetAllNotificationsQuery;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetNotificationByIdQuery;
import com.deltatech.diligencetech.platform.shared.domain.services.NotificationQueryService;
import com.deltatech.diligencetech.platform.shared.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationQueryServiceImpl implements NotificationQueryService {
  private NotificationRepository notificationRepository;

  public NotificationQueryServiceImpl(NotificationRepository notificationRepository) {
    this.notificationRepository = notificationRepository;
  }

  @Override
  public List<Notification> handle(GetAllNotificationsQuery query) {
    return notificationRepository.findAll();
  }

  @Override
  public Optional<Notification> handle(GetNotificationByIdQuery query) {
    return notificationRepository.findById(query.id());
  }
}
