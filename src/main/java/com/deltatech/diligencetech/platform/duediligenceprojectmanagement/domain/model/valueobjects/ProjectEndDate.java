package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public record ProjectEndDate(Date endDate) {
    public ProjectEndDate() {this(null);}

    public Date getProjectEndDate() { return endDate; }

    public ProjectEndDate {
        if (endDate == null){
            throw new IllegalArgumentException("Project end date cannot be null");
        }
    }
}
