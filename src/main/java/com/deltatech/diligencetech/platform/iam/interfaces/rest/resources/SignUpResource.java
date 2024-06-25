package com.deltatech.diligencetech.platform.iam.interfaces.rest.resources;

import com.deltatech.diligencetech.platform.iam.domain.model.entities.Role;

import java.util.List;

public record SignUpResource(String username, String email, String password, String firstname, String lastname, List<String> roles) {
}
