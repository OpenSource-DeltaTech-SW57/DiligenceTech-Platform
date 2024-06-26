package com.deltatech.diligencetech.platform.communications.domain.model.aggregates;


import com.deltatech.diligencetech.platform.communications.domain.model.commands.CreateEmailCommand;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;



@Getter
@Entity
public class Email extends AuditableAbstractAggregateRoot<Email> {

    @Column
    @Getter
    private String senderEmail;

    @Column
    @Getter
    private String receiverEmail;

    @Column
    @Getter
    private String title;

    @Column
    @Getter
    private String description;

    @Column
    @Getter
    private String message;




    public Email() {
    }

    public Email(CreateEmailCommand command){
        this.senderEmail = command.senderEmail();
        this.receiverEmail = command.receiverEmail();
        this.title = command.title();
        this.description = command.description();
        this.message = command.message();
    }

}
