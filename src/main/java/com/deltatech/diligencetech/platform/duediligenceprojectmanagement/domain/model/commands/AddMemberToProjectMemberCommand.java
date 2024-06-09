package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;

public record AddMemberToProjectMemberCommand(AgentRecordId agentId, Long projectId) {
}
