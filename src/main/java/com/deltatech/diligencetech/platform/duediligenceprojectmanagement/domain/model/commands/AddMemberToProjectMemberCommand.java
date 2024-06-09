package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;

public record AddMemberToProjectMemberCommand(AgentRecordId agentId, Long projectId) {
}
