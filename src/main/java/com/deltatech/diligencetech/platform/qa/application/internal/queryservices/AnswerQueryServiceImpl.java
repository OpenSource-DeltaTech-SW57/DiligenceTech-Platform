package com.deltatech.diligencetech.platform.qa.application.internal.queryservices;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Answer;
import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAllAnswersQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAllQuestionsQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAnswerByIdQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetQuestionByIdQuery;
import com.deltatech.diligencetech.platform.qa.domain.services.AnswerQueryService;
import com.deltatech.diligencetech.platform.qa.infrastructure.persistence.jpa.repositories.AnswerRepository;
import com.deltatech.diligencetech.platform.qa.infrastructure.persistence.jpa.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerQueryServiceImpl implements AnswerQueryService {

    private final AnswerRepository answerRepository;

    public AnswerQueryServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public List<Answer> handle(GetAllAnswersQuery query) {
        return answerRepository.findAll();
    }

    @Override
    public Optional<Answer> handle(GetAnswerByIdQuery query) {
        return answerRepository.findById(query.id());
    }
}
