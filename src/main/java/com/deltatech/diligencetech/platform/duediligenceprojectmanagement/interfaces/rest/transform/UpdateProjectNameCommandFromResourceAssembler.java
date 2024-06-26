package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectNameCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateProjectResource;

public class UpdateProjectNameCommandFromResourceAssembler {
    public static UpdateProjectNameCommand toCommandFromResource(Long projectId, UpdateProjectResource resource) {
        //old
        //return new UpdateProjectCommand(projectId, resource.projectFullName(), resource.managerFirstName(), resource.managerLastName(), resource.startDate(), resource.endDate(), resource.budget(), resource.progress(), resource.status());
        //new
        return new UpdateProjectNameCommand(projectId, resource.projectFullName());
    }
}