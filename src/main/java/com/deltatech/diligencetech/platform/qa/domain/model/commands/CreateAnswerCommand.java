package com.deltatech.diligencetech.platform.qa.domain.model.commands;

public record CreateAnswerCommand(String content) {
    public CreateAnswerCommand {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content must not be null or empty");
        }
    }
}
