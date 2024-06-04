package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public record ProjectEndDate(Date projectEndDate) {
    public ProjectEndDate() {this(null);}

    public Date getProjectEndDate() { return projectEndDate; }

    public ProjectEndDate {
        if (projectEndDate == null){
            throw new IllegalArgumentException("Project end date cannot be null");
        }
    }
}
