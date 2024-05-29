package com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class DueDiligenceProject extends AbstractAggregateRoot<DueDiligenceProject> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;
}