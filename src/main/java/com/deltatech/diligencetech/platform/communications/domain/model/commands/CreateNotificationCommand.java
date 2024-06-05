package com.deltatech.diligencetech.platform.communications.domain.model.commands;

import com.deltatech.diligencetech.platform.communications.domain.model.valueobjects.NotificationData;

public record CreateNotificationCommand(String type, String content){}