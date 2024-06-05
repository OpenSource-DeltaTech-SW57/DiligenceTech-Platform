package com.deltatech.diligencetech.platform.duediligenceagents.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.UpdateAgentCommand;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.AgentData;
import com.deltatech.diligencetech.platform.duediligenceagents.interfaces.rest.resources.UpdateAgentResource;

public class UpdateAgentCommandFromResourceAssembler
{
  public static UpdateAgentCommand toCommandFromResource(Long agentId, String username) {
return new UpdateAgentCommand(agentId, username);
  }
}
