package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectName(String projectFullName) {
    public ProjectName(){this(null);}

    public String getProjectFullName() {return projectFullName;}

    public ProjectName {
        if (projectFullName == null || projectFullName.isBlank()) {
            throw  new IllegalArgumentException("Project name cannot be null or blank");
        }
    }

}
