package com.deltatech.diligencetech.platform.duediligence.domain.services;

import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.duediligence.shared.aggregates.Agent;

import java.util.Optional;

public interface AgentCommandService {
  Optional<Agent> handle(CreateAgentCommand command);
}
