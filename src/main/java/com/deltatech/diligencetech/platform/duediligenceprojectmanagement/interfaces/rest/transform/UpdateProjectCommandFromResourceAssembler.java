package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateProjectResource;

public class UpdateProjectCommandFromResourceAssembler {
    public static UpdateProjectCommand toCommandFromResource(Long projectId, UpdateProjectResource resource) {
        return new UpdateProjectCommand(projectId, resource.projectFullName(), resource.managerFirstName(), resource.managerLastName(), resource.startDate(), resource.endDate(), resource.budget(), resource.progress(), resource.status());
    }
}