package com.deltatech.diligencetech.platform.duediligenceagents.domain.services;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAgentByIdQuery;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.queries.GetAllAgentsQuery;

import java.util.List;
import java.util.Optional;

public interface AgentQueryService {
  Optional<Agent> handle(GetAgentByIdQuery query);
  List<Agent> handle (GetAllAgentsQuery query);

}

