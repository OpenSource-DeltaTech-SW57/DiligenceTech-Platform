package com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateInformationGroupCommand;
import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
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

    @ManyToOne
    @Getter
    //@JoinColumn
    private DueDiligenceProject dueDiligenceProject;

    @ManyToOne
    @Getter
    //@JoinColumn
    private InformationGroup parent;

    @OneToMany
    @Getter
    private List<InformationGroup> children;

    @OneToMany
    @Getter
    private List<Document> documents;

    @OneToMany
    @Getter
    private List<Question> questions;

    @Column(nullable = false)
    @Getter
    private String identifier;

    @Column(nullable = false)
    @Getter
    private String name;

    @Column(nullable = false)
    @Getter
    private String buyStatus;

    @Column(nullable = false)
    @Getter
    private String sellStatus;

    @Column(nullable = false)
    @Getter
    private boolean obligatory;

    @Column(nullable = false)
    @Getter
    private String priority;

    @CreatedDate
    @Column(nullable = false)
    private Date createdAt;

    @LastModifiedDate
    @Column(nullable = false)
    private Date updatedAt;

    public InformationGroup(boolean obligatory, String identifier, String name, String priority, String buyStatus, String sellStatus) {
        this.dueDiligenceProject = null;
        this.parent = null;
        this.children = null;
        this.documents = null;
        this.questions = null;
        this.obligatory = obligatory;
        this.identifier = identifier;
        this.name = name;
        this.priority = priority;
        this.sellStatus = sellStatus;
        this.buyStatus = buyStatus;
    }

    public InformationGroup() {}

    public InformationGroup(CreateInformationGroupCommand command) {
        this.dueDiligenceProject = null;
        this.parent = null;
        this.children = null;
        this.documents = null;
        this.questions = null;
        this.obligatory = command.obligatory();
        this.identifier = command.identifier();
        this.name = command.name();
        this.priority = command.priority();
        this.sellStatus = command.sellStatus();
        this.buyStatus = command.buyStatus();
    }

}
