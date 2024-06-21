package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateAreaCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateFolderCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.*;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Folder extends AuditableAbstractAggregateRoot<Folder> {
    // particular attributes

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

    @Column
    @Getter
    private String name;



    @ManyToOne
    @Getter
    @JoinColumn(name = "area_id")
    private Area parent;

    public Folder(CreateFolderCommand command) {
        this.innerFiles = new FilesList();
        this.priority = FolderPriority.LOW;
        this.buyStatus = FolderStatus.NOT_STARTED;
        this.sellStatus = FolderStatus.NOT_STARTED;
        this.name = command.name();

    }

    public void insertParent(Area parent) {
        this.parent = parent;
    }


    public Folder() {
        this.innerFiles = new FilesList();
        this.priority = FolderPriority.LOW;
        this.buyStatus = FolderStatus.NOT_STARTED;
        this.sellStatus = FolderStatus.NOT_STARTED;
        this.name = "";
    }

    public Folder updateName(String name) {
        this.name = name;
        return this;
    }
}
