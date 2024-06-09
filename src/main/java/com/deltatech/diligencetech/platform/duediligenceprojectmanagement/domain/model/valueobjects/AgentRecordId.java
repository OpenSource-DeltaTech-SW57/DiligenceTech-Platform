package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record AgentRecordId(String agentRecordId) {
    public AgentRecordId() {this(UUID.randomUUID().toString());}

    public AgentRecordId {
        if(agentRecordId == null || agentRecordId.isBlank()) {
            throw new IllegalArgumentException("Agent record profileId cannot be null or blank");
        }
    }
}
