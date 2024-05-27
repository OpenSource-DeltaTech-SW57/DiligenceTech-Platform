package com.deltatech.diligencetech.platform.shared.interfaces.rest.transform;

public record CreateNotificationResource(String id, String username, String type, String content, String createdAt) {
}
