package com.deltatech.diligencetech.platform.iam.interfaces.rest.resources;

public record AuthenticatedUserResource(Long id, String email, String username, String token) {
}
