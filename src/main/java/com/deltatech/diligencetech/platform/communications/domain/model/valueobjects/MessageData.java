package com.deltatech.diligencetech.platform.communications.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record MessageData(String content) {
}
