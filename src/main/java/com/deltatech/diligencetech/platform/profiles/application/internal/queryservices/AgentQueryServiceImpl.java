package com.deltatech.diligencetech.platform.profiles.application.internal.queryservices;

import com.deltatech.diligencetech.platform.profiles.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByUsernameQuery;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByEmailQuery;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByIdQuery;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAllAgentsQuery;
import com.deltatech.diligencetech.platform.profiles.domain.services.AgentQueryService;
import com.deltatech.diligencetech.platform.profiles.infrastructure.persistence.jpa.repositories.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgentQueryServiceImpl implements AgentQueryService{

  private final AgentRepository agentRepository;


  public AgentQueryServiceImpl(AgentRepository agentRepository) {
    this.agentRepository = agentRepository;
  }


  @Override
  public Optional<Agent> handle(GetAgentByIdQuery query) {
    return agentRepository.findById(query.id());
  }

  @Override
  public Optional<Agent> handle(GetAgentByEmailQuery query) {
    return agentRepository.findByEmail(query.email());
  }

  @Override
  public List<Agent> handle(GetAllAgentsQuery query) {
    return agentRepository.findAll();
  }

  @Override
  public Optional<Agent> handle(GetAgentByUsernameQuery query) {
    return agentRepository.findByUsername(query.username());
  }

}
