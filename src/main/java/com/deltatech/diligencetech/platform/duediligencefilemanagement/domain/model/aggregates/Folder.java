package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.FolderData;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.InnerFiles;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.InnerFolders;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Folder extends AuditableAbstractAggregateRoot<Folder> {
    // particular attributes
    @Getter
    @Embedded
    private FolderData folderData;

    @Embedded
    private InnerFolders innerFolders;

    @Embedded
    private InnerFiles innerFiles;
}
