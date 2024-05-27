package com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources.InformationGroupResource;

public class InformationGroupResourceFromEntityAssembler {
    public static InformationGroupResource toResourceFromEntity(InformationGroup entity) {
        return new InformationGroupResource(
                entity.getId(),
                null,
                entity.getIdentifier(),
                entity.getName(),
                null,
                entity.getBuyStatus(),
                entity.getSellStatus()
        );
    }
}
