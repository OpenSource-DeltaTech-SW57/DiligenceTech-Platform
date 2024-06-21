package com.deltatech.diligencetech.platform.profiles.interfaces.acl;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.profiles.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByEmailQuery;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByIdQuery;
import com.deltatech.diligencetech.platform.profiles.domain.services.AgentCommandService;
import com.deltatech.diligencetech.platform.profiles.domain.services.AgentQueryService;
import org.springframework.stereotype.Service;

@Service
public class AgentContextFacade {
  private final AgentCommandService agentCommandService;
  private final AgentQueryService agentQueryService;

  public AgentContextFacade(AgentCommandService agentCommandService, AgentQueryService agentQueryService) {
    this.agentCommandService = agentCommandService;
    this.agentQueryService = agentQueryService;
  }

  public Long createAgent(String code, String email, String username, String password, String imageUrl) {
    var createAgentCommand = new CreateAgentCommand(code, email, username, password, imageUrl);
    var agentId = agentCommandService.handle(createAgentCommand);
    var getAgentByIdQuery = new GetAgentByIdQuery(agentId);
    var agent = agentQueryService.handle(getAgentByIdQuery);
    if (agent.isEmpty()) return 0L;
    return agent.get().getId();
  }

  /**
   * Fetches the agent id by email
   *
   * @param email the email
   * @return the agent id
   */
  public Long fetchAgentIdByEmail(String email) {
    var getAgentByEmailQuery = new GetAgentByEmailQuery(email);
    var agent = agentQueryService.handle(getAgentByEmailQuery);
    if (agent.isEmpty()) return 0L;
    return agent.get().getId();
  }

}
