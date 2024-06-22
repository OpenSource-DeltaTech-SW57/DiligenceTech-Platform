package com.deltatech.diligencetech.platform.communications.interfaces.rest.resources;

public record EmailResource(Long id, Long senderId, Long receiverId, String message) {
}
