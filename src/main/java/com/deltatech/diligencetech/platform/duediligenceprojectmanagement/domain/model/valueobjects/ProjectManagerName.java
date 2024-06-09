package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectManagerName(String firstName, String lastName) {
    public ProjectManagerName() {this (null, null);}

    public String getProjectManagerFullName() {return String.format("%s %s", firstName, lastName);}

    public ProjectManagerName {
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name cannot be null or blank");
        }

        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name cannot be null or blank");
        }
    }
}
