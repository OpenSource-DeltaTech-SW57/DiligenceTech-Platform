package com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record AgentData(String email,String username, String password ) {
}
