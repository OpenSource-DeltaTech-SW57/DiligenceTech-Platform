package com.deltatech.diligencetech.platform.shared.domain.services;

import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetAgentByIdQuery;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetAllAgentsQuery;

import java.util.List;
import java.util.Optional;

public interface AgentQueryService {

  List<Agent> handle(GetAllAgentsQuery query);
  Optional<Agent> handle(GetAgentByIdQuery query);


}
