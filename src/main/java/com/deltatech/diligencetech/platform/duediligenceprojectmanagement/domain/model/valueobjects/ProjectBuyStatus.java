package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectBuyStatus(String buyStatus) {
    public ProjectBuyStatus() {this(null);}

    public ProjectBuyStatus {
        if (buyStatus.isBlank()) {
            throw new IllegalArgumentException("Project buyStatus cannot be null or blank");
        }
    }
}
