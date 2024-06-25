package com.deltatech.diligencetech.platform.iam.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AgentId(Long agentId) {
    public AgentId {
        if (agentId < 0) {
            throw new IllegalArgumentException("Agent agentId cannot be negative");
        }
    }

    public AgentId() {
        this(0L);
    }
}
