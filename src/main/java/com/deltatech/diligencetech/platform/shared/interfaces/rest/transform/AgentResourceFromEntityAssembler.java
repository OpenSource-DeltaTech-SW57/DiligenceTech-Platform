package com.deltatech.diligencetech.platform.shared.interfaces.rest.transform;


import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.resources.AgentResource;

public class AgentResourceFromEntityAssembler {
  public static AgentResource toResourceFromEntity(Agent entity){
    return new AgentResource(entity.getAgentId(), entity.getEmail(), entity.getUsername(), entity.getPassword() ,"");

  }

}
