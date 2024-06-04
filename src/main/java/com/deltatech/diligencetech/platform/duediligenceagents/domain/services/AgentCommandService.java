package com.deltatech.diligencetech.platform.duediligenceagents.domain.services;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.ProfileId;

public interface AgentCommandService {
    ProfileId handle(CreateAgentCommand command);
}
