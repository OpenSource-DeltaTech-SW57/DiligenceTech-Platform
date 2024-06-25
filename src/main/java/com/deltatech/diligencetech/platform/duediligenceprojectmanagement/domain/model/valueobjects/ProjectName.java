package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectName(String projectName) {
    public ProjectName(){this(null);}

    public String getProjectFullName() {return projectName;}

    public ProjectName {
        if (projectName == null || projectName.isBlank()) {
            throw  new IllegalArgumentException("Project name cannot be null or blank");
        }
    }

}