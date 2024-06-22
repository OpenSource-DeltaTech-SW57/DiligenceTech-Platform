package com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.profiles.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.CreateAgentResource;

public class CreateAgentCommandFromResourceAssembler {
    public static CreateAgentCommand toCommandFromResource(CreateAgentResource resource) {
        return new CreateAgentCommand(resource.code(), resource.email(), resource.username(), resource.password(), resource.image());
    }
}