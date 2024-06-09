package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities.ProjectMemberItem;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.ProjectMemberItemResource;

public class ProjectMemberItemResourceFromEntityAssembler {
    public static ProjectMemberItemResource toResourceFromEntity(ProjectMemberItem entity) {
        return new ProjectMemberItemResource(entity.getId(), entity.getDueDiligenceProject().getId(), entity.getAgentRecordId().agentRecordId());
    }
}
