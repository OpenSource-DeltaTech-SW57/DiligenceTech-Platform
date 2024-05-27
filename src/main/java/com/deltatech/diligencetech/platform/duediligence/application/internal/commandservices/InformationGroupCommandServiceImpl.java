package com.deltatech.diligencetech.platform.duediligence.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateInformationGroupCommand;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupCommandService;
import com.deltatech.diligencetech.platform.duediligence.infrastructure.persistence.jpa.repositories.InformationGroupRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InformationGroupCommandServiceImpl implements InformationGroupCommandService {
    private final InformationGroupRepository informationGroupRepository;

    public InformationGroupCommandServiceImpl(InformationGroupRepository informationGroupRepository) {
        this.informationGroupRepository = informationGroupRepository;
    }

    @Override
    public Optional<InformationGroup> handle(CreateInformationGroupCommand command) {
        var informationGroup = new InformationGroup(command);
        var createdInformationGroup = informationGroupRepository.save(informationGroup);
        return Optional.of(createdInformationGroup);
    }
}
