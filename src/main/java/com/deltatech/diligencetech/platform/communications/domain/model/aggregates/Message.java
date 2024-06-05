package com.deltatech.diligencetech.platform.communications.domain.model.aggregates;


import com.deltatech.diligencetech.platform.communications.domain.model.valueobjects.AnswersList;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Message extends AuditableAbstractAggregateRoot<Message> {

    @Embedded
    private AnswersList answers;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Message question;

    public Message() {}
}
