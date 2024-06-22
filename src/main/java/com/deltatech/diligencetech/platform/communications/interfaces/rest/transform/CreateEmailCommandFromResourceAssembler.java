package com.deltatech.diligencetech.platform.communications.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.communications.domain.model.commands.CreateEmailCommand;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.resources.CreateEmailResource;

public class CreateEmailCommandFromResourceAssembler {
    public static CreateEmailCommand toCommandFromResource(CreateEmailResource resource){
        return new CreateEmailCommand( resource.senderId(), resource.receiverId(), resource.message());
    }
}
