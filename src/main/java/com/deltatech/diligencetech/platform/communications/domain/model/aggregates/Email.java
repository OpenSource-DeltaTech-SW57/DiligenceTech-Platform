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
    private Long senderId;

    @Column
    @Getter
    private Long receiverId;

    @Column
    @Getter
    private String message;




    public Email() {
    }

    public Email(CreateEmailCommand command){
        this.senderId = command.senderId();
        this.receiverId = command.receiverId();
        this.message = command.message();
    }

}
