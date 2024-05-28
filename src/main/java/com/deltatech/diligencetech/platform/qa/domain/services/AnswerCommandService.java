package com.deltatech.diligencetech.platform.qa.domain.services;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Answer;
import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateAnswerCommand;

import java.util.Optional;


public interface AnswerCommandService {
    Optional<Answer> handle(CreateAnswerCommand command);
}
