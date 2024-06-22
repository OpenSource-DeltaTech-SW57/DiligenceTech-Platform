package com.deltatech.diligencetech.platform.communications.domain.model.commands;

import com.deltatech.diligencetech.platform.communications.domain.model.valueobjects.NotificationData;

public record CreateNotificationCommand(Long agentId, String type, String content){}