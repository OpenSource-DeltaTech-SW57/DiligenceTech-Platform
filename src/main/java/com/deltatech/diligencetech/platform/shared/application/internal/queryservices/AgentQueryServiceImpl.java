package com.deltatech.diligencetech.platform.shared.application.internal.queryservices;

import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetAgentByIdQuery;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetAllAgentsQuery;
import com.deltatech.diligencetech.platform.shared.domain.services.AgentQueryService;
import com.deltatech.diligencetech.platform.shared.infrastructure.persistence.jpa.repositories.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AgentQueryServiceImpl implements AgentQueryService {
  private final AgentRepository agentRepository;

  public AgentQueryServiceImpl(AgentRepository agentRepository) {
    this.agentRepository = agentRepository;
  }

  @Override
  public List<Agent> handle(GetAllAgentsQuery query) {
    return agentRepository.findAll();
  }

  @Override
  public Optional<Agent> handle(GetAgentByIdQuery query) {
    return agentRepository.findById(query.id());
  }
}
