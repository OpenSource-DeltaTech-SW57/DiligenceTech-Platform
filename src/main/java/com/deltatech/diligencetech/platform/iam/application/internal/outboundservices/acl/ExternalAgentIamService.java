package com.deltatech.diligencetech.platform.iam.application.internal.outboundservices.acl;

import com.deltatech.diligencetech.platform.iam.domain.model.valueobjects.AgentId;
import com.deltatech.diligencetech.platform.profiles.interfaces.acl.AgentContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalAgentService {
    private final AgentContextFacade agentContextFacade;

    public ExternalAgentService(AgentContextFacade agentContextFacade) {
        this.agentContextFacade = agentContextFacade;
    }

    public Optional<AgentId> fetchAgentIdByEmail(String email) {
        var agentId = agentContextFacade.fetchAgentIdByEmail(email);
        if (agentId == 0L) return Optional.empty();
        return Optional.of(new AgentId(agentId));
    }

    public Optional<AgentId> createAgent(String username, String email, String password, String firstname, String lastName) {
        var agentId = agentContextFacade.createAgent(username, email, password, firstname, lastName);
        if(agentId == 0L) return Optional.empty();
        return Optional.of(new AgentId(agentId));
    }
}
