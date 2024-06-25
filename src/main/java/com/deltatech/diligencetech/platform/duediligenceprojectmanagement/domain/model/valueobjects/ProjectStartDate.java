package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.Date;

@Embeddable
public record ProjectStartDate(Date startDate) {
    public ProjectStartDate() {this(null);}

    public Date getStartDate() { return startDate; }

    public ProjectStartDate {
        if (startDate == null){
            throw new IllegalArgumentException("Project start date cannot be null");
        }
    }
}