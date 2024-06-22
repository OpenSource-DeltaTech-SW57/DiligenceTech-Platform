package com.deltatech.diligencetech.platform.communications.interfaces.rest.resources;

public record CreateEmailResource(Long senderId, Long receiverId, String message) {
}
