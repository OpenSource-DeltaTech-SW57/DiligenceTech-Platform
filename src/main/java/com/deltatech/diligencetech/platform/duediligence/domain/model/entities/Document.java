package com.deltatech.diligencetech.platform.duediligence.domain.model.entities;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "information_group_id")
    private InformationGroup informationGroup;

    @Getter
    private String sellSideAgentId;

    private String ownerId;

    private String fileName;

    private String fileUrl;

    public Document() {}

    public Document(InformationGroup informationGroup, String sellSideAgentId, String ownerId, String fileName, String fileUrl) {
        this.informationGroup = informationGroup;
        this.sellSideAgentId = sellSideAgentId;
        this.ownerId = ownerId;
        this.fileName = fileName;
        this.fileUrl = fileUrl;
    }
}
