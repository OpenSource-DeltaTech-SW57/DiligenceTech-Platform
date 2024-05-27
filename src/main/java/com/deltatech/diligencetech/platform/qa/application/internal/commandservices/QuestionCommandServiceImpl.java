package com.deltatech.diligencetech.platform.qa.application.internal.commandservices;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateQuestionCommand;
import com.deltatech.diligencetech.platform.qa.domain.services.QuestionCommandService;
import com.deltatech.diligencetech.platform.qa.infrastructure.persistence.jpa.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionCommandServiceImpl implements QuestionCommandService {
    private final QuestionRepository questionRepository;

    public QuestionCommandServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Optional<Question> handle(CreateQuestionCommand command) {
        var question = new Question(command);
        var createdQuestion = questionRepository.save(question);
        return Optional.of(createdQuestion);
    }

}
