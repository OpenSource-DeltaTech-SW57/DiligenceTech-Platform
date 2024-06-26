package com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.AgentProjectResource;

public class ProjectResourceFromEntityAssembler {
    public static AgentProjectResource toResourceFromEntity(Project entity, String agentRecordId) {
        return new AgentProjectResource(entity.getId(), entity.getName().projectName(), entity.getProjectMember().getProjectMemberItemWithAgentRecordId(new AgentRecordId(agentRecordId)).getAgentRole().agentRole());
    }
}
