package com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.profiles.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.AgentResource;

public class AgentResourceFromEntityAssembler {
  public static AgentResource toResourceFromEntity(Agent entity) {
    return new AgentResource(entity.getCode(), entity.getAgentData().email(), entity.getAgentData().username(), entity.getAgentData().password(), entity.getImage().imageUrl());
  }

}
