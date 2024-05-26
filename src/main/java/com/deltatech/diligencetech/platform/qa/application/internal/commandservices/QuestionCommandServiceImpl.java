package com.deltatech.diligencetech.platform.qa.application.internal.commandservices;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateQuestionCommand;
import com.deltatech.diligencetech.platform.qa.domain.services.QuestionCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionCommandServiceImpl implements QuestionCommandService {
    @Override
    public Optional<Question> handle(CreateQuestionCommand command) {
        return Optional.empty();
    }

}
