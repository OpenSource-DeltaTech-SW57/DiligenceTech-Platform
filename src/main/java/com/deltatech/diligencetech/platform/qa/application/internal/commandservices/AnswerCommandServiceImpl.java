package com.deltatech.diligencetech.platform.qa.application.internal.commandservices;


import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Answer;
import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateAnswerCommand;
import com.deltatech.diligencetech.platform.qa.domain.services.AnswerCommandService;
import com.deltatech.diligencetech.platform.qa.infrastructure.persistence.jpa.repositories.AnswerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerCommandServiceImpl implements AnswerCommandService {
    private final AnswerRepository answerRepository;

    public AnswerCommandServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Optional<Answer> handle(CreateAnswerCommand command) {
        var answer = new Answer(command);
        var createdAnswer = answerRepository.save(answer);
        return Optional.of(createdAnswer);
    }
}

