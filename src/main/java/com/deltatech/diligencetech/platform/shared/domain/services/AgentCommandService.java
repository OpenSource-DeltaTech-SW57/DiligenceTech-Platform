package com.deltatech.diligencetech.platform.shared.domain.services;

import com.deltatech.diligencetech.platform.shared.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Agent;

import java.util.Optional;

public interface AgentCommandService {
  Optional<Agent> handle(CreateAgentCommand command);
}
