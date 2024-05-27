package com.deltatech.diligencetech.platform.qa.application.internal.queryservices;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAllQuestionsQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetQuestionByIdQuery;
import com.deltatech.diligencetech.platform.qa.domain.services.QuestionQueryService;
import com.deltatech.diligencetech.platform.qa.infrastructure.persistence.jpa.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionQueryServiceImpl implements QuestionQueryService {

    private final QuestionRepository questionRepository;

    public QuestionQueryServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> handle(GetAllQuestionsQuery query) {
        return questionRepository.findAll();
    }

    @Override
    public Optional<Question> handle(GetQuestionByIdQuery query) {
        return questionRepository.findById(query.id());
    }
}
