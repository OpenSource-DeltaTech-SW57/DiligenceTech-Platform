package com.deltatech.diligencetech.platform.iam.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.iam.domain.model.aggregates.User;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;

public class AuthenticatedUserResourceFromEntityAssembler {
    public static AuthenticatedUserResource toResourceFromEntity(User user, String token, String username) {
        return new AuthenticatedUserResource(user.getId(), user.getUserEmail(), username, token);
    }
}
