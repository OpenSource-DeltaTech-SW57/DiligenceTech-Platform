package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectCompletedCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateProjectCompletedResource;

public class UpdateProjectCompletedCommandFromResourceAssembler {
    public static UpdateProjectCompletedCommand toCommandFromResource(Long projectId, UpdateProjectCompletedResource resource) {
        return new UpdateProjectCompletedCommand(projectId, resource.completed());
    }
}
