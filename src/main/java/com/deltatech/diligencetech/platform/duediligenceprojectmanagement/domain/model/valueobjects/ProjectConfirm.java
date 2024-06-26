package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectConfirm(Boolean confirm) {
    public ProjectConfirm() {this(false);}
}
