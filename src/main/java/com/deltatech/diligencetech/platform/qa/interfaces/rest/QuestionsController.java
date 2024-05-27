package com.deltatech.diligencetech.platform.qa.interfaces.rest;

import com.deltatech.diligencetech.platform.qa.domain.services.QuestionCommandService;
import com.deltatech.diligencetech.platform.qa.domain.services.QuestionQueryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/questions")

public class QuestionsController {
    private final QuestionCommandService questionCommandService;
    private final QuestionQueryService questionQueryService;

    public QuestionsController(QuestionCommandService questionCommandService, QuestionQueryService questionQueryService) {
        this.questionCommandService = questionCommandService;
        this.questionQueryService = questionQueryService;
    }

    @PostMapping
    public void createQuestion() {
    }
}
