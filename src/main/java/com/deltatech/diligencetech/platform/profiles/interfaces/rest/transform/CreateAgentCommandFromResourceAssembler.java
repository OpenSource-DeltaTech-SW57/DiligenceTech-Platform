package com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.profiles.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.CreateAgentResource;

public class CreateAgentCommandFromResourceAssembler {
    public static CreateAgentCommand toCommandFromResource(CreateAgentResource resource) {
<<<<<<< HEAD
        return new CreateAgentCommand(resource.username(), resource.email(), resource.password(), "src/images/file", resource.firstname(), resource.lastName(), "-");
=======
        return new CreateAgentCommand(resource.code(), resource.email(), resource.username(), resource.biography(), resource.image());
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
    }
}