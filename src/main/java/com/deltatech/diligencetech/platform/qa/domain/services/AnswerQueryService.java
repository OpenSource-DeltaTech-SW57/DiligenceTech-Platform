package com.deltatech.diligencetech.platform.qa.domain.services;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Answer;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAllAnswersQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAnswerByIdQuery;

import java.util.List;
import java.util.Optional;

public interface AnswerQueryService {
    List<Answer> handle(GetAllAnswersQuery query);
    Optional<Answer> handle(GetAnswerByIdQuery query);
}
