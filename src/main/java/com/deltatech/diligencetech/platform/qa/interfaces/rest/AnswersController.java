package com.deltatech.diligencetech.platform.qa.interfaces.rest;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Answer;
import com.deltatech.diligencetech.platform.qa.domain.services.AnswerCommandService;
import com.deltatech.diligencetech.platform.qa.domain.services.AnswerQueryService;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.AnswerResource;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.transform.AnswerResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.transform.CreateAnswerCommandFromResourceAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/answers")

public class AnswersController {
    private final AnswerCommandService answerCommandService;
    private final AnswerQueryService answerQueryService;

    public AnswersController(AnswerCommandService answerCommandService, AnswerQueryService answerQueryService) {
        this.answerCommandService = answerCommandService;
        this.answerQueryService = answerQueryService;
    }

    @PostMapping
    public ResponseEntity<AnswerResource> createAnswer(@RequestBody AnswerResource resource){
        Optional<Answer> answer = answerCommandService.handle(CreateAnswerCommandFromResourceAssembler.toCommandFromResource(resource));
        return answer.map(source->new ResponseEntity(AnswerResourceFromEntityAssembler.toResourceFromEntity(source),CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }
}
