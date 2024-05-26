package com.deltatech.diligencetech.platform.duediligence.domain.model.commands;

import java.util.Date;

public record CreateNotificationCommand(String type, String content, Date createdAt) {
public CreateNotificationCommand{}
}
