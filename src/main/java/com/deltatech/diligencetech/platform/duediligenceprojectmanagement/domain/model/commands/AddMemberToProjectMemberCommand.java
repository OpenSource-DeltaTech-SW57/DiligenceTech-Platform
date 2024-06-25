package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentEmail;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRole;

public record AddMemberToProjectMemberCommand(AgentRecordId agentId, Long projectId, AgentRole agentRole){}
