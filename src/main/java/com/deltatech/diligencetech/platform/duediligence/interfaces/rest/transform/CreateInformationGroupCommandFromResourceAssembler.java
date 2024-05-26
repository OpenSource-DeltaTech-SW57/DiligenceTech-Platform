package com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateInformationGroupCommand;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources.InformationGroupResource;

public class CreateInformationGroupCommandFromResourceAssembler {
    public static CreateInformationGroupCommand toCommandFromResource(InformationGroupResource resource) {
        return new CreateInformationGroupCommand(
                resource.identifier(),
                resource.name(),
                resource.buyStatus(),
                resource.sellStatus(),
                false,
                null
        );
    }
}
