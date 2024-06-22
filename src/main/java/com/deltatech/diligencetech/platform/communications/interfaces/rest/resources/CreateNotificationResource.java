package com.deltatech.diligencetech.platform.communications.interfaces.rest.resources;

public record CreateNotificationResource(Long agentId, String type, String content) {
}
