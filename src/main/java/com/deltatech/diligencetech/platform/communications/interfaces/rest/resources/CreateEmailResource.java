package com.deltatech.diligencetech.platform.communications.interfaces.rest.resources;

public record CreateEmailResource(String senderEmail, String receiverEmail, String title, String description, String message) {
}
