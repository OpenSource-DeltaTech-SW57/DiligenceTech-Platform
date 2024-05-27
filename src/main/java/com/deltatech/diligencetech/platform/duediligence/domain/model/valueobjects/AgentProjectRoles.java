package com.deltatech.diligencetech.platform.duediligence.domain.model.valueobjects;


import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Agent;
import jakarta.persistence.Embeddable;

@Embeddable
public record AgentProjectRoles(Agent agent, boolean confirmation) {
    public AgentProjectRoles()
    {
        this(null, false);
    }
    public String AgentProjectInvitationFormat(Agent agent, boolean confirmation) {
        return String.format("%S", confirmation);
    }

}
