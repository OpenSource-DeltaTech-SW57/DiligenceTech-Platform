package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.DueDiligenceProject;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.DueDiligenceProjectResource;

public class DueDiligenceProjectResourceFromEntityAssembler {
    public static DueDiligenceProjectResource toResourceFromEntity(DueDiligenceProject entity) {
        return new DueDiligenceProjectResource(entity.getId(), entity.getName().projectFullName(), entity.getManagerName().getProjectManagerFullName(), entity.getStatus().getProjectStatusName());
    }
}
