package com.deltatech.diligencetech.platform.profiles.interfaces.acl;

import com.deltatech.diligencetech.platform.profiles.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByEmailQuery;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByUsernameQuery;
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

<<<<<<< HEAD
  public Long createAgent(String username, String email, String password, String firstname, String lastName) {
    var createAgentCommand = new CreateAgentCommand(username, email, password, "src/images/file", firstname, lastName, "-");
=======
  public Long createAgent(String code, String email, String username, String biography, String imageUrl) {
    var createAgentCommand = new CreateAgentCommand(code, email, username, biography, imageUrl);
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
    var agentId = agentCommandService.handle(createAgentCommand);
    var getAgentByIdQuery = new GetAgentByIdQuery(agentId);
    var agent = agentQueryService.handle(getAgentByIdQuery);
    if (agent.isEmpty()) return 0L;
    return agent.get().getId();
  }

  /**
   * Fetches the agent id by code
   *
   * @param code the code
   * @return the agent id
   */
  public Long fetchAgentIdByCode(String code) {
    var getAgentByCodeQuery = new GetAgentByUsernameQuery(code);
    var agent = agentQueryService.handle(getAgentByCodeQuery);
    if (agent.isEmpty()) return 0L;
    return agent.get().getId();
  }

  public Long fetchAgentIdByEmail(String email) {
    var getAgentIdByEmailQuery = new GetAgentByEmailQuery(email);
    var agent = agentQueryService.handle(getAgentIdByEmailQuery);
    if (agent.isEmpty()) return 0L;
    return agent.get().getId();
  }

  public String fetchUsernameByAgentId(Long id) {
    var getUsernameByAgentId = new GetAgentByIdQuery(id);
    var username = agentQueryService.handle(getUsernameByAgentId);
    if(username.isEmpty()) return "";
    return username.get().getUsername();
  }

  public String fetchEmailByAgentId(Long id) {
    var getEmailByAgentId = new GetAgentByIdQuery(id);
    var email = agentQueryService.handle(getEmailByAgentId);
    if(email.isEmpty()) return "";
    return email.get().getEmail();
  }

}
