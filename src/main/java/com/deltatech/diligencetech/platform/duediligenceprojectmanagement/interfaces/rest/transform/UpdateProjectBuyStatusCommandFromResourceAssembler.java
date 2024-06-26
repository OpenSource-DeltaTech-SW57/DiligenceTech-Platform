package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectBuyStatusCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateProjectBuyStatusResource;

public class UpdateProjectBuyStatusCommandFromResourceAssembler {
    public static UpdateProjectBuyStatusCommand toCommandFromResource(Long projectId, UpdateProjectBuyStatusResource resource) {
        return new UpdateProjectBuyStatusCommand(projectId, resource.buystatus());
    }
}
