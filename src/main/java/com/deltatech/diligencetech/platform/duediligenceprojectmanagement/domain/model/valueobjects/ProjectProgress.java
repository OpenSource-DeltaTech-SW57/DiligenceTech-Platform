package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectProgress(Long projectProgress) {
    public ProjectProgress(){ this(0L);}

    public Long getProjectProgress() { return projectProgress; }

    public ProjectProgress {
        if (projectProgress == null || projectProgress < 0 || projectProgress > 100) {
            throw new IllegalArgumentException("Progress cannot be null or less than 0 or greater than 100");
        }
    }
}
