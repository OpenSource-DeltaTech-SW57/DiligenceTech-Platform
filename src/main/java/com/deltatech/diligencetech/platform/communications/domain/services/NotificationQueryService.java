package com.deltatech.diligencetech.platform.communications.domain.services;

import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetAllNotificationsQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetNotificationByIdQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetNotificationsByAgentIdQuery;

import java.util.List;
import java.util.Optional;

public interface NotificationQueryService{
    List<Notification> handle(GetAllNotificationsQuery query);
    Optional<Notification> handle(GetNotificationByIdQuery query);
    List<Notification> handle(GetNotificationsByAgentIdQuery query);

}