package com.deltatech.diligencetech.platform.qa.domain.services;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAllQuestionsQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetQuestionByIdQuery;

import java.util.List;
import java.util.Optional;

public interface QuestionQueryService {
    List<Question> handle(GetAllQuestionsQuery query);
    Optional<Question> handle(GetQuestionByIdQuery query);
}
