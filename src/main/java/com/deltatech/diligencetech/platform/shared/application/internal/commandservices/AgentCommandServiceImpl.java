package com.deltatech.diligencetech.platform.duediligence.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.duediligence.domain.services.AgentCommandService;
import com.deltatech.diligencetech.platform.duediligence.infrastructure.persistence.jpa.repositories.AgentRepository;
import com.deltatech.diligencetech.platform.duediligence.shared.aggregates.Agent;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AgentCommandServiceImpl implements AgentCommandService {
  private final AgentRepository agentRepository;

  public AgentCommandServiceImpl(AgentRepository agentRepository) {
    this.agentRepository = agentRepository;
  }

  @Override
  public Optional<Agent> handle(CreateAgentCommand command) {
    if(agentRepository.existByAgentId(command.agentId())){
      throw new IllegalArgumentException("Agent with id " + command.agentId() + " already exists");
    }
    var agent = new Agent(command);
    var createdAgent = agentRepository.save(agent);
    return Optional.of(agent);
  }


}
