package com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.profiles.domain.model.commands.UpdateAgentBiographyAndProfilePicCommand;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.UpdateAgentBiographyAndProfilePicResource;

public class UpdateAgentBiographyAndPicCommandFromResourceAssembler {

    public static UpdateAgentBiographyAndProfilePicCommand toCommandFromResource(Long agentId, UpdateAgentBiographyAndProfilePicResource resource) {
        return new UpdateAgentBiographyAndProfilePicCommand(agentId, resource.biography(), resource.imageUrl());
    }
}
