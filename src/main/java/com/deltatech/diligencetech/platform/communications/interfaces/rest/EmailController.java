package com.deltatech.diligencetech.platform.communications.interfaces.rest;


import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Email;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetAllEmailsQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetEmailByIdQuery;
import com.deltatech.diligencetech.platform.communications.domain.services.EmailCommandService;
import com.deltatech.diligencetech.platform.communications.domain.services.EmailQueryService;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.resources.CreateEmailResource;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.resources.EmailResource;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.transform.CreateEmailCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.transform.EmailResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/v1/emails", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Email")


public class EmailController {

    private final EmailQueryService emailQueryService;
    private final EmailCommandService emailCommandService;

    public EmailController(EmailQueryService emailQueryService, EmailCommandService emailCommandService) {
        this.emailQueryService = emailQueryService;
        this.emailCommandService = emailCommandService;
    }

    @GetMapping
    public ResponseEntity<List<EmailResource>> getAllEmails() {
        var getAllEmailsQuery = new GetAllEmailsQuery();
        var emails = emailQueryService.handle(getAllEmailsQuery);
        var emailsResources = emails.stream()
                .map(EmailResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(emailsResources);
    }
    @GetMapping("/{emailId}")
    public ResponseEntity<EmailResource> getEmailById(@PathVariable Long emailId) {
        var getEmailByIdQuery = new GetEmailByIdQuery(emailId);
        var email = emailQueryService.handle(getEmailByIdQuery);
        if (email.isEmpty()) return ResponseEntity.notFound().build();
        var emailResource = EmailResourceFromEntityAssembler.toResourceFromEntity(email.get());
        return ResponseEntity.ok(emailResource);
    }
    @PostMapping
    public ResponseEntity<EmailResource> createEmail(@RequestBody CreateEmailResource resource) {
        var createEmailCommand = CreateEmailCommandFromResourceAssembler.toCommandFromResource(resource);
        var email = emailCommandService.handle(createEmailCommand);
        if (email.isEmpty()) return ResponseEntity.badRequest().build();
        var emailResource = EmailResourceFromEntityAssembler.toResourceFromEntity(email.get());
        return new ResponseEntity<>(emailResource, HttpStatus.CREATED);
    }


}
