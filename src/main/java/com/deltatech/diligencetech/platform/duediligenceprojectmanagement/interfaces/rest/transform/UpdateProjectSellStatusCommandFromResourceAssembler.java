package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectSellStatusCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateProjectSellStatusResource;

public class UpdateProjectSellStatusCommandFromResourceAssembler {
    public static UpdateProjectSellStatusCommand toCommandFromResource(Long projectId, UpdateProjectSellStatusResource resource) {
        return new UpdateProjectSellStatusCommand(projectId, resource.sellStatus());
    }
}
