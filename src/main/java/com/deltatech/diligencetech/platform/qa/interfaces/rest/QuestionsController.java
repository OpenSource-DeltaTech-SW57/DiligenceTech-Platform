package com.deltatech.diligencetech.platform.qa.interfaces.rest;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetQuestionByIdQuery;
import com.deltatech.diligencetech.platform.qa.domain.services.QuestionCommandService;
import com.deltatech.diligencetech.platform.qa.domain.services.QuestionQueryService;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.QuestionResource;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.transform.CreateQuestionCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.transform.QuestionResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

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
    public ResponseEntity<QuestionResource> createQuestion(@RequestBody QuestionResource resource){
        Optional<Question> question = questionCommandService.handle(CreateQuestionCommandFromResourceAssembler.toCommandFromResource(resource));
        return question.map(source->new ResponseEntity<>(QuestionResourceFromEntityAssembler.toResourceFromEntity(source),CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResource> getQuestionById(@PathVariable Long id){
        var getQuestionByIdQuery = new GetQuestionByIdQuery(id);
        var question = questionQueryService.handle(getQuestionByIdQuery);
        if(question.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var questionResource = QuestionResourceFromEntityAssembler.toResourceFromEntity(question.get());
        return ResponseEntity.ok(questionResource);
    }



}
