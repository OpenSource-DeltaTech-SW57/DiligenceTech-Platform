package com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.profiles.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.CreateAgentResource;

public class CreateAgentCommandFromResourceAssembler {
    public static CreateAgentCommand toCommandFromResource(CreateAgentResource resource) {
        return new CreateAgentCommand(resource.username(), resource.email(), resource.password(), "src/images/file", resource.firstname(), resource.lastName(), "-");
    }
}