package com.deltatech.diligencetech.platform.duediligence.domain.services;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllNotificationsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetNotificationByIdQuery;


import java.util.List;
import java.util.Optional;

public interface NotificationQueryService {
  List<Notification> handle(GetAllNotificationsQuery query);
  Optional<Notification> handle(GetNotificationByIdQuery query);


}
