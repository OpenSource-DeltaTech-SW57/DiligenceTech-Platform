package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.CreateDueDiligenceProjectResource;

public class CreateDueDiligenceProjectCommandFromResourceAssembler {
    public static CreateDueDiligenceProjectCommand toCommandFromResource(CreateDueDiligenceProjectResource resource) {
        return new CreateDueDiligenceProjectCommand(resource.projectFullName(), resource.managerFirstName(), resource.managerLastName(), resource.startDate(), resource.endDate(), resource.budget(), resource.progress(), resource.status());
    }
}
