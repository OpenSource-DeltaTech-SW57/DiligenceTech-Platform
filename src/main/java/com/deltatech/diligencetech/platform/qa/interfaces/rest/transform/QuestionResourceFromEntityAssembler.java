package com.deltatech.diligencetech.platform.qa.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.QuestionResource;

public class QuestionResourceFromEntityAssembler {
    public static QuestionResource toResourceFromEntity(Question entity) {
        return new QuestionResource(entity.getId(), entity.getBuySideStatus(), entity.getSellSideStatus(), entity.getNumber(), entity.getContent());
    }
}
