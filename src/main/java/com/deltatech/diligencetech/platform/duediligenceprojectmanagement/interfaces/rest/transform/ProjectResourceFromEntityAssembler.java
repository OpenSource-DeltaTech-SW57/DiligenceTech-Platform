package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.ProjectResource;

public class ProjectResourceFromEntityAssembler {
    public static ProjectResource toResourceFromEntity(Project entity) {
        //old
        //return new ProjectResource(entity.getId(), entity.getName().projectFullName(), getProjectManagerFullName(), entity.getStatus().getProjectStatusName());
        //new
        return new ProjectResource(entity.getId(), entity.getName().projectName());
    }
}