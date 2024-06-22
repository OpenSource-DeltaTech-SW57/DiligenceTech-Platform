package com.deltatech.diligencetech.platform.iam.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.iam.domain.model.commands.SignInCommand;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand fromResource(SignInResource resource) {
        return new SignInCommand(resource.username(), resource.password());
    }
}
