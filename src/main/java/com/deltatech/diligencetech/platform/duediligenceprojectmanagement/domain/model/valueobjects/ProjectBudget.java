package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectBudget(Float projectBudgetAmount) {
    public ProjectBudget() {this(0.0F);}

    public Float getProjectBudgetAmount() {return projectBudgetAmount;}

    public ProjectBudget {
        if (projectBudgetAmount == null || projectBudgetAmount < 0) {
            throw new IllegalArgumentException("Budget amount cannot be null or less than or equal to zero");
        }
    }
}