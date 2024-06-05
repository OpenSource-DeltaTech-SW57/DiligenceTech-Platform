package com.deltatech.diligencetech.platform.duediligenceagents.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAgentByCodeQuery;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAgentByIdQuery;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAllAgentsQuery;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.services.AgentQueryService;
import com.deltatech.diligencetech.platform.duediligenceagents.infrastructure.persistence.jpa.repositories.AgentRepository;
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
  public Optional<Agent> handle(GetAgentByCodeQuery query) {
    return agentRepository.findByCode(query.code());
  }

  @Override
  public List<Agent> handle(GetAllAgentsQuery query) {
    return agentRepository.findAll();
  }


}
