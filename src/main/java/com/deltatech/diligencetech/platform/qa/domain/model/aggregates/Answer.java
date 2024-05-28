package com.deltatech.diligencetech.platform.qa.domain.model.aggregates;


import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateAnswerCommand;
import com.deltatech.diligencetech.platform.qa.domain.model.commands.CreateQuestionCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Answer extends AbstractAggregateRoot<Answer> {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private String content;



    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;


    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;


//sellSideAgent
    protected Answer() {
    }


    public Answer(CreateAnswerCommand command){
        this.content = command.content();
    }
}
