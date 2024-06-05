package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;


import jakarta.persistence.Embeddable;

@Embeddable
public record ProjectData(String code, String name, Boolean confirmed) {
}
