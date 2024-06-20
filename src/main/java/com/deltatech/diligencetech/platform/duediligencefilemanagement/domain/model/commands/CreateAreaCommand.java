package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands;

public record CreateAreaCommand(Long code, String name, Boolean obligatory) {
    public CreateAreaCommand {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (obligatory == null) {
            throw new IllegalArgumentException("Obligatory cannot be null");
        }
    }
}
