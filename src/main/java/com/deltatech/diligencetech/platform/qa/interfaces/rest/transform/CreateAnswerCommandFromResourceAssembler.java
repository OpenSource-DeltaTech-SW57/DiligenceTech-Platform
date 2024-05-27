package com.deltatech.diligencetech.platform.qa.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateAnswerCommand;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.AnswerResource;

public class CreateAnswerCommandFromResourceAssembler {
    public static CreateAnswerCommand toCommandFromResource(AnswerResource resource) {
        return new CreateAnswerCommand(resource.content());
    }
}
