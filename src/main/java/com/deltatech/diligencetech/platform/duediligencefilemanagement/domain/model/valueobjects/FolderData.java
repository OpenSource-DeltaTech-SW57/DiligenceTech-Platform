package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record FolderData(String name) {
    public FolderData() {
        this("");
    }
}
