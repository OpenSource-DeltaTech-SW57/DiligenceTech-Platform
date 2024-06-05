package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.ProjectData;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Project extends AuditableAbstractAggregateRoot<Project> {

    @Embedded
    @Getter
    private ProjectData projectData;
}
