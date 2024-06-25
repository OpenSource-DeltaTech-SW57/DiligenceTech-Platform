package com.deltatech.diligencetech.platform.communications.domain.model.commands;

public record CreateEmailCommand(String senderEmail, String receiverEmail, String title, String description, String message) {}
