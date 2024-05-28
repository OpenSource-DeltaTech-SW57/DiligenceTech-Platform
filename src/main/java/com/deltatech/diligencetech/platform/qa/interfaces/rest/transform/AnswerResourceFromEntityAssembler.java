package com.deltatech.diligencetech.platform.qa.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Answer;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.AnswerResource;

public class AnswerResourceFromEntityAssembler {
    public static AnswerResource toResourceFromEntity(Answer entity) {
        return new AnswerResource(entity.getId(), entity.getContent());
    }
}
