package com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.profiles.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.AgentResource;

public class AgentResourceFromEntityAssembler {
  public static AgentResource toResourceFromEntity(Agent entity) {
    return new AgentResource( entity.getId() ,entity.getEmail(), entity.getUsername(), entity.getBiography(), entity.getImageUrl());

}
}