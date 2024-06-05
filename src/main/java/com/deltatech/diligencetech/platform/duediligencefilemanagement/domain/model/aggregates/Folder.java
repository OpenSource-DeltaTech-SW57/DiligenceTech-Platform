package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.*;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Folder extends AuditableAbstractAggregateRoot<Folder> {
    // particular attributes
    @Getter
    @Embedded
    private FolderData folderData;

    @Embedded
    private FoldersList innerFolders;

    @Embedded
    private FilesList innerFiles;

    @Column
    @Getter
    private FolderPriority priority;

    @Column
    @Getter
    private FolderStatus buyStatus;

    @Column
    @Getter
    private FolderStatus sellStatus;

    @ManyToOne
    @JoinColumn(name = "parent")
    private Folder parent;
}
