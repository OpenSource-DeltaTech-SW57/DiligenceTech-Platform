package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

public record AgentRole(String agentRole) {
    public AgentRole() {this(null);}

    public AgentRole {
        if(agentRole == null || agentRole.isBlank()) {
            throw new IllegalArgumentException("Agent role cannot be null or blank");
        }
    }
}