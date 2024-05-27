package com.deltatech.diligencetech.platform.qa.domain.services;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateQuestionCommand;

import java.util.Optional;

public interface QuestionCommandService {
    Optional<Question> handle(CreateQuestionCommand command);
}
