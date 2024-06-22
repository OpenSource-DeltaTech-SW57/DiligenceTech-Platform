package com.deltatech.diligencetech.platform.iam.interfaces.rest;

import com.deltatech.diligencetech.platform.iam.domain.services.UserCommandService;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.resources.AuthenticatedUserResource;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.resources.SignInResource;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.resources.SignUpResource;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.resources.UserResource;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.transform.AuthenticatedUserResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.transform.SignInCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.transform.SignUpCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.iam.interfaces.rest.transform.UserResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/v1/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Authentication", description = "Authentication Endpoints")
public class AuthenticationController {
    private final UserCommandService userCommandService;

    public AuthenticationController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthenticatedUserResource> signIn(@RequestBody SignInResource resource) {
        var signInCommand = SignInCommandFromResourceAssembler.fromResource(resource);
        var authenticatedUser = userCommandService.handle(signInCommand);
        if (authenticatedUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        var authenticatedUserResource = AuthenticatedUserResourceFromEntityAssembler.toResourceFromEntity(authenticatedUser.get().getLeft(), authenticatedUser.get().getRight());
        return ResponseEntity.ok(authenticatedUserResource);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<UserResource> signUp(@RequestBody SignUpResource resource) {
        var signUpCommand = SignUpCommandFromResourceAssembler.fromResource(resource);
        var user = userCommandService.handle(signUpCommand);
        if (user.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var userResource = UserResourceFromEntityAssembler.toResourceFromEntity(user.get());
        return new ResponseEntity<>(userResource, HttpStatus.CREATED);
    }
}
