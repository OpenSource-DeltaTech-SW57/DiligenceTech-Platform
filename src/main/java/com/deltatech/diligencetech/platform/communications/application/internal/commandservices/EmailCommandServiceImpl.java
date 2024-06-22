package com.deltatech.diligencetech.platform.communications.application.internal.commandservices;

import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Email;
import com.deltatech.diligencetech.platform.communications.domain.model.commands.CreateEmailCommand;
import com.deltatech.diligencetech.platform.communications.domain.model.commands.DeleteEmailCommand;
import com.deltatech.diligencetech.platform.communications.domain.services.EmailCommandService;
import com.deltatech.diligencetech.platform.communications.infrastructure.persistence.jpa.repositories.EmailRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmailCommandServiceImpl implements EmailCommandService {

    private final EmailRepository emailRepository;

    public EmailCommandServiceImpl(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }
    @Override
    public Optional<Email> handle(CreateEmailCommand command) {
        var email = new Email(command);
        emailRepository.save(email);
        return Optional.of(email);
    }

    @Override
    public void handle(DeleteEmailCommand command) {
        if (!emailRepository.existsById(command.emailId())) {
            throw new IllegalArgumentException("Email does not exist");
        }
        try {
            emailRepository.deleteById(command.emailId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting Email: " + e.getMessage());
        }
    }




}
