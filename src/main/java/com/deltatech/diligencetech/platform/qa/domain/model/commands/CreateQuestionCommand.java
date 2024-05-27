package com.deltatech.diligencetech.platform.qa.domain.model.commands;

public record CreateQuestionCommand(String content, String buySideStatus, String sellSideStatus, int number) {
    public CreateQuestionCommand {
        if (content == null || content.isBlank()) {
            throw new IllegalArgumentException("Content must not be null or empty");
        }
        if (buySideStatus == null || buySideStatus.isBlank()) {
            throw new IllegalArgumentException("Buy side status must not be null or empty");
        }
        if (sellSideStatus == null || sellSideStatus.isBlank()) {
            throw new IllegalArgumentException("Sell side status must not be null or empty");
        }
    }
}
