package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates;

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

    @Embedded
    private FoldersList folders;
}
