package com.deltatech.diligencetech.platform.profiles.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record AgentData(String email,String username, String password ) {
}
