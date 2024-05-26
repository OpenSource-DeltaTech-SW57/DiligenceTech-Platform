package com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateDocumentCommand;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Agent;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Document extends AbstractAggregateRoot<Document> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    /*
    // Relationships
    @ManyToOne
    @Getter
    //@JoinColumn
    private InformationGroup informationGroup;

    @ManyToOne
    @Getter
    //@JoinColumn
    private Agent owner;
     */

    @Column(nullable = false)
    @Getter
    private String fileName;

    @Column(nullable = false)
    @Getter
    private String fileUrl;

    protected Document() {}

    protected Document(CreateDocumentCommand command) {
        this.fileName = command.fileName();
        this.fileUrl = command.fileUrl();
    }
}
