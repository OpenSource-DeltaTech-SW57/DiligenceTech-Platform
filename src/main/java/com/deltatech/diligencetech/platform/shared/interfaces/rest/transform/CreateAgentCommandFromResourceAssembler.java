package com.deltatech.diligencetech.platform.shared.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.shared.domain.model.commands.CreateAgentCommand;

public class CreateAgentCommandFromResourceAssembler {
  public static CreateAgentCommand toCommandFromResource(CreateAgentResource resource){
    return new CreateAgentCommand(resource.agentId(), resource.username(), resource.password(), resource.email());
  }
}
