package com.deltatech.diligencetech.platform.duediligence.domain.services;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateInformationGroupCommand;

import java.util.Optional;

public interface InformationGroupCommandService {
    Optional<InformationGroup> handle(CreateInformationGroupCommand command);
}
