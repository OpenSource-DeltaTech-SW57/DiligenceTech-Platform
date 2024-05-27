package com.deltatech.diligencetech.platform.shared.interfaces.rest.transform;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.resources.NotificationResource;

public class NotificationResourceFromEntityAssembler {
  public static NotificationResource toResourceFromEntity(Notification entity){
    return new NotificationResource(entity.getId(), entity.getUsername(), entity.getType(), entity.getContent() ,"");

  }
}
