package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectCompleted(Boolean completed) {
    public ProjectCompleted() {this(false);}
}
