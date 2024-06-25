package com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.profiles.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.AgentResource;

public class AgentResourceFromEntityAssembler {
  public static AgentResource toResourceFromEntity(Agent entity) {
<<<<<<< HEAD
    return new AgentResource(entity.getId(), entity.getEmail(), entity.getUsername(), entity.getImageUrl(), entity.getFullName(), entity.getLocation());
=======
    return new AgentResource( entity.getId() ,entity.getEmail(), entity.getUsername(), entity.getBiography(), entity.getImageUrl());

>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
}
}