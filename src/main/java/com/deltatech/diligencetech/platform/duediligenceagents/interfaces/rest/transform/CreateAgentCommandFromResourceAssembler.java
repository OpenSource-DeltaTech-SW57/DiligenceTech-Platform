package com.deltatech.diligencetech.platform.duediligenceagents.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.duediligenceagents.interfaces.rest.resources.CreateAgentResource;

public class CreateAgentCommandFromResourceAssembler {
  public static CreateAgentCommand toCommandFromResource(CreateAgentResource resource) {
    return new CreateAgentCommand(resource.id(), resource.email(), resource.username(), resource.password(), resource.image());
  }
}
