package com.deltatech.diligencetech.platform.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record AgentName(String firstname, String lastName) {
    public AgentName(){
        this(null,null);
    }

    public String getFullName(){
        return String.format("%s %s", firstname, lastName);
    }

    public AgentName {
        if (firstname == null || firstname.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }

    }
}
