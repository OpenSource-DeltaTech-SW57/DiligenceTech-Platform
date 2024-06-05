package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.entities;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.FileData;
import com.deltatech.diligencetech.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Document extends AuditableModel {
    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private FileData fileData;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    // constructors

}
