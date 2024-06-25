package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;

public record GetProjectMemberItemByProjectIdAndAgentId(Long projectId, AgentRecordId agentId) {
}