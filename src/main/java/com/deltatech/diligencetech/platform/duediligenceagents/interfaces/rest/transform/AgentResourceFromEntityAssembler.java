package com.deltatech.diligencetech.platform.duediligenceagents.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.duediligenceagents.interfaces.rest.resources.AgentResource;

import java.util.Optional;

public class AgentResourceFromEntityAssembler {
  public static AgentResource toResourceFromEntity(Agent entity) {
    return new AgentResource(entity.getCode(), entity.getAgentData().email(), entity.getAgentData().username(), entity.getAgentData().password(), entity.getImage().imageUrl());
  }

}
