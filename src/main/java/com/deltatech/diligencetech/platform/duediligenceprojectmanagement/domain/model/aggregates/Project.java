package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.ProjectData;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class Project extends AuditableAbstractAggregateRoot<Project> {

    @Embedded
    @Getter
    private ProjectData projectData;

}
