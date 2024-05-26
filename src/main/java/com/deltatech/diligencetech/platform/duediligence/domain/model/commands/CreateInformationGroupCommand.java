package com.deltatech.diligencetech.platform.duediligence.domain.model.commands;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.DueDiligenceProject;

public record CreateInformationGroupCommand(
        String identifier,
        String name,
        String buyStatus,
        String sellStatus,
        boolean obligatory,
        String priority
        ) {
    public CreateInformationGroupCommand {

    }
}
