package com.deltatech.diligencetech.platform.qa.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateQuestionCommand;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.CreateQuestionResource;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.QuestionResource;

public class CreateQuestionCommandFromResourceAssembler {
    public static CreateQuestionCommand toCommandFromResource(QuestionResource resource) {
        return new CreateQuestionCommand(resource.content(),resource.buySideStatus(), resource.sellSideStatus(), resource.number());
    }
}
