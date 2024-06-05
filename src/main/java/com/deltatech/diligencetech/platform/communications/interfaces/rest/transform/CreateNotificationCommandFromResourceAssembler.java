package com.deltatech.diligencetech.platform.communications.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.communications.domain.model.commands.CreateNotificationCommand;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.resources.CreateNotificationResource;

public class CreateNotificationCommandFromResourceAssembler {
    public static CreateNotificationCommand toCommandFromResource(CreateNotificationResource resource){
        return new CreateNotificationCommand(resource.type(), resource.content());
    }
}
