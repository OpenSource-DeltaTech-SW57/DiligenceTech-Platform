package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectSellStatus(String sellStatus) {
    public ProjectSellStatus() {this(null);}

    public ProjectSellStatus {
        if (sellStatus.isBlank()) {
            throw new IllegalArgumentException("Project sellStatus cannot be null or blank");
        }
    }
}