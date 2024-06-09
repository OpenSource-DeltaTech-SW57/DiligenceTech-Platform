package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateDueDiligenceProjectResource;

public class UpdateDueDiligenceProjectCommandFromResourceAssembler {
    public static UpdateDueDiligenceProjectCommand toCommandFromResource(Long projectId, UpdateDueDiligenceProjectResource resource) {
        return new UpdateDueDiligenceProjectCommand(projectId, resource.projectFullName(), resource.managerFirstName(), resource.managerLastName(), resource.startDate(), resource.endDate(), resource.budget(), resource.progress(), resource.status());
    }
}
