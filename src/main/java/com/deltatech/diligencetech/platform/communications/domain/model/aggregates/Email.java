package com.deltatech.diligencetech.platform.communications.domain.model.aggregates;


import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Email extends AuditableAbstractAggregateRoot<Email> {

}
