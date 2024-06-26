package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectConfirmCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateProjectConfirmResource;

public class UpdateProjectConfirmCommandFromResourceAssembler {
    public static UpdateProjectConfirmCommand toCommandFromResource(Long projectId, UpdateProjectConfirmResource resource) {
        return new UpdateProjectConfirmCommand(projectId, resource.confirm());
    }
}
