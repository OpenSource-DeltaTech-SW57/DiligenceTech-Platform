package com.deltatech.diligencetech.platform.shared.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.shared.domain.model.commands.CreateNotificationCommand;

public class CreateNotificationCommandFromResourceAssembler {
  public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource){
    return new CreateNotificationCommand(resource.id(), resource.username(), resource.type(), resource.content(), resource.createdAt());
  }
}
