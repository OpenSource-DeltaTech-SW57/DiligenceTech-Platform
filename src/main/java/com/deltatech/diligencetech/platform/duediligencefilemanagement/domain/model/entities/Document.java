package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.entities;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateDocumentCommand;
import com.deltatech.diligencetech.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import javax.print.Doc;

@Getter
@Entity
public class Document extends AuditableModel {
    // attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column
    @Getter
    private String filename;

    @Column
    @Getter
    private String fileUrl;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    public Document(CreateDocumentCommand command) {
        this.filename = command.filename();
        this.fileUrl = command.fileUrl();
    }

    public Document() {

    }

    public void insertFolder(Folder folder) {
        this.folder = folder;
    }

    public Document updateName(String filename) {
        this.filename = filename;
        return this;
    }


}
