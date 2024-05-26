package com.deltatech.diligencetech.platform.duediligence.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateInformationGroupCommand;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InformationGroupCommandServiceImpl implements InformationGroupCommandService {

    @Override
    public Optional<InformationGroup> handle(CreateInformationGroupCommand command) {
        return Optional.empty();
    }
}
