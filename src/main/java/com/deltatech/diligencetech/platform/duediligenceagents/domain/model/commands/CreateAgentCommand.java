package com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands;

public record CreateAgentCommand(Long profileId, String agentRolName, String agentRolDescription, String rootImageProfileName, String rootImageProfileDescription) {
}
