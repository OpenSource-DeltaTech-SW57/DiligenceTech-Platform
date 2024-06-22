package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities.ProjectMemberItem;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.ProjectMemberItemResource;

public class ProjectMemberItemResourceFromEntityAssembler {
    public static ProjectMemberItemResource toResourceFromEntity(ProjectMemberItem entity) {
        return new ProjectMemberItemResource(entity.getId(), entity.getProject().getId(), entity.getAgentRecordId().agentRecordId(), entity.getAgentRole().agentRole());
    }
}