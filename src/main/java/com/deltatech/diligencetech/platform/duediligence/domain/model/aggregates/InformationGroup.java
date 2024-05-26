package com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class InformationGroup extends AbstractAggregateRoot<InformationGroup> {
    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

        @Column(nullable = false)
        @Getter
        private boolean obligatory;

    @Column(nullable = false)
    @Getter
    private String groupIdentifier;

    @Column(nullable = false)
    @Getter
    private String name;

    @Column(nullable = false)
    @Getter
    private String priority;

    @Column(nullable = false)
    @Getter
    private String buySideStatus;

    @Column(nullable = false)
    @Getter
    private String sellSideStatus;

    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    // private List<InformationGroup> children;
    // private List<Document> documents;
    // private List<Question> questions;

    // CONSTRUCTOR
    protected InformationGroup() {}
    // METHODS
}
