package com.deltatech.diligencetech.platform.shared.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.shared.domain.model.commands.CreateNotificationCommand;

public class CreateNotificationCommandFromResource {
  public static <CreateNotificationResource> CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource){
    return new CreateNotificationCommand(resource.username(), resource.type(), resource.content());
  }

}
