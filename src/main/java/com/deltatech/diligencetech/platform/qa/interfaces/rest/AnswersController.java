package com.deltatech.diligencetech.platform.qa.interfaces.rest;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Answer;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAllAnswersQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAllQuestionsQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetAnswerByIdQuery;
import com.deltatech.diligencetech.platform.qa.domain.model.queries.GetQuestionByIdQuery;
import com.deltatech.diligencetech.platform.qa.domain.services.AnswerCommandService;
import com.deltatech.diligencetech.platform.qa.domain.services.AnswerQueryService;
import com.deltatech.diligencetech.platform.qa.infrastructure.persistence.jpa.repositories.AnswerRepository;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.AnswerResource;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.resources.QuestionResource;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.transform.AnswerResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.transform.CreateAnswerCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.qa.interfaces.rest.transform.QuestionResourceFromEntityAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/answers")


public class AnswersController {
    private final AnswerCommandService answerCommandService;
    private final AnswerQueryService answerQueryService;
    private final AnswerRepository answerRepository;

    public AnswersController(AnswerCommandService answerCommandService, AnswerQueryService answerQueryService, AnswerRepository answerRepository) {
        this.answerCommandService = answerCommandService;
        this.answerQueryService = answerQueryService;
        this.answerRepository = answerRepository;
    }

    @PostMapping
    public ResponseEntity<AnswerResource> createAnswer(@RequestBody AnswerResource resource){
        Optional<Answer> answer = answerCommandService.handle(CreateAnswerCommandFromResourceAssembler.toCommandFromResource(resource));
        return answer.map(source->new ResponseEntity(AnswerResourceFromEntityAssembler.toResourceFromEntity(source),CREATED))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResource> getAnswerById(@PathVariable Long id){
        var getAnswerByIdQuery = new GetAnswerByIdQuery(id);
        var answer = answerQueryService.handle(getAnswerByIdQuery);
        if(answer.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        var answerResource = AnswerResourceFromEntityAssembler.toResourceFromEntity(answer.get());
        return ResponseEntity.ok(answerResource);
    }


    @GetMapping
    public ResponseEntity<List<AnswerResource>> getAllAnswers(){
        var getAllAnswersQuery = new GetAllAnswersQuery();
        var answers = answerQueryService.handle(getAllAnswersQuery);
        var answerResource = answers.stream().map(AnswerResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(answerResource);
    }
}
