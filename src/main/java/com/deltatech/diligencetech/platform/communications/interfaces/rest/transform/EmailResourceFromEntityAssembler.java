package com.deltatech.diligencetech.platform.communications.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Email;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.resources.EmailResource;

public class EmailResourceFromEntityAssembler {
    public static EmailResource toResourceFromEntity(Email entity) {
        return new EmailResource(entity.getId(), entity.getSenderEmail(), entity.getReceiverEmail(), entity.getTitle(), entity.getDescription(), entity.getMessage());
    }
}
