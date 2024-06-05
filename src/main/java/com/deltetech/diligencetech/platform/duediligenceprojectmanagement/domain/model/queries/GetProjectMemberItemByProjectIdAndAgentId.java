package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;

public record GetProjectMemberItemByProjectIdAndAgentId(Long projectId, AgentRecordId agentId) {
}
