package com.deltatech.diligencetech.platform.communications.domain.model.commands;

public record CreateEmailCommand(Long senderId, Long receiverId, String message) {}
