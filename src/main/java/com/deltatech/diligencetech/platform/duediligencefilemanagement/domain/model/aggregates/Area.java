package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.AgentData;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.Image;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateAreaCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.valueobjects.*;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
public class Area extends AuditableAbstractAggregateRoot<Area> {
    // particular attributes
    @Getter
    @Embedded
    private AreaData areaData;

    @Column(unique = true)
    @Getter
    private String code;

    @Embedded
    private FoldersList folders;

    public Area(CreateAreaCommand command) {
        this.areaData = new AreaData(command.name(), command.obligatory());
        this.folders = new FoldersList();
        this.code = String.valueOf(command.code());
    }

    public Area() {
        this.areaData = new AreaData();
        this.folders = new FoldersList();
    }

    public Area updateName(String name) {
        this.areaData = new AreaData(name, this.areaData.obligatory());
        return this;
    }
}
