package com.deltatech.diligencetech.platform.communications.domain.services;

import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Email;
import com.deltatech.diligencetech.platform.communications.domain.model.commands.CreateEmailCommand;
import com.deltatech.diligencetech.platform.communications.domain.model.commands.DeleteEmailCommand;

import java.util.Optional;

public interface EmailCommandService {
    Optional<Email> handle(CreateEmailCommand command);
    void handle(DeleteEmailCommand command);
}
