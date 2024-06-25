package com.deltatech.diligencetech.platform.iam.application.internal.outboundservices.acl;


import com.deltatech.diligencetech.platform.profiles.interfaces.acl.AgentContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalAgentServiceForIam {

  private final AgentContextFacade agentContextFacade;

  public ExternalAgentServiceForIam(AgentContextFacade agentContextFacade) {
    this.agentContextFacade = agentContextFacade;
  }


  /**
   * Fetch agentId by email
   *
   * @param code the email to search for
   * @return profileId if found, empty otherwise
   */
  public Optional<Long>  fetchAgentIdByCode(String code) {
    var agentId = agentContextFacade.fetchAgentIdByCode(code);
    if (agentId == 0L) return Optional.empty();
    return Optional.of(agentId);
  }

    /**
     * Create an agent
     *
     * @param code the code
     * @param email the email
     * @param username the username
     * @param password the password
     * @param imageUrl the image url
     * @return profileId if created, empty otherwise
     */
  public Optional<Long> createAgent(String code, String email, String username, String password, String imageUrl) {
    var agentId = agentContextFacade.createAgent( code, email, username, password, imageUrl);
    if (agentId == 0L) return Optional.empty();
    return Optional.of(agentId);
  }
}
