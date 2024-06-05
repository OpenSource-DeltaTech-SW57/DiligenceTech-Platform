package com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.AgentData;

public record UpdateAgentCommand(Long id, String username) {
}
