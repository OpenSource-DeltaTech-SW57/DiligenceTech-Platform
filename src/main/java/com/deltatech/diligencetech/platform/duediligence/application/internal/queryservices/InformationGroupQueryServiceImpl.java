package com.deltatech.diligencetech.platform.duediligence.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllInformationGroupsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetInformationGroupByIdQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupQueryService;
import com.deltatech.diligencetech.platform.duediligence.infrastructure.persistence.jpa.repositories.InformationGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationGroupQueryServiceImpl implements InformationGroupQueryService {
    private final InformationGroupRepository informationGroupRepository;

    public InformationGroupQueryServiceImpl(InformationGroupRepository informationGroupRepository) {
        this.informationGroupRepository = informationGroupRepository;
    }

    @Override
    public List<InformationGroup> handle(GetAllInformationGroupsQuery query) {
        return informationGroupRepository.findAll();
    }

    @Override
    public Optional<InformationGroup> handle(GetInformationGroupByIdQuery query) {
        return informationGroupRepository.findById(query.id());
    }
}
