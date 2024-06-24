package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateProjectCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.CreateProjectResource;

public class CreateProjectCommandFromResourceAssembler {
    public static CreateProjectCommand toCommandFromResource(CreateProjectResource resource) {
        //old
        //return new CreateProjectCommand(resource.projectFullName(), resource.managerFirstName(), resource.managerLastName(), resource.startDate(), resource.endDate(), resource.budget(), resource.progress(), resource.status());
        //new
        return new CreateProjectCommand(resource.projectFullName());
    }
}