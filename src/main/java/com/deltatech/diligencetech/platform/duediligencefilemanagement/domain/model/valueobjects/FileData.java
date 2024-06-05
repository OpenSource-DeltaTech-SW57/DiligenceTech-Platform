package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record FileData(String fileName, String fileUrl) {
    public FileData() {
        this(null, null);
    }
}
