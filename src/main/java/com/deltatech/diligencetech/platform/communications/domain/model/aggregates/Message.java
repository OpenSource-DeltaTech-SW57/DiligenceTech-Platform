package com.deltatech.diligencetech.platform.communications.domain.model.aggregates;


import com.deltatech.diligencetech.platform.communications.domain.model.valueobjects.AnswersList;
import com.deltatech.diligencetech.platform.communications.domain.model.valueobjects.MessageData;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Message extends AuditableAbstractAggregateRoot<Message> {

    @Embedded
    private AnswersList answers;

    @Column
    @Getter
    private String senderId;

    @Column
    @Getter
    private String receiverId;

    @Column
    @Getter
    private String content;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Message question;

    public Message() {}
}
