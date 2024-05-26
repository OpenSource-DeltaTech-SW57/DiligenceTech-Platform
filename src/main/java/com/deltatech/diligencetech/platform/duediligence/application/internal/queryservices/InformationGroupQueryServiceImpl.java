package com.deltatech.diligencetech.platform.duediligence.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllInformationGroupsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetInformationGroupByIdQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.services.InformationGroupQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformationGroupQueryServiceImpl implements InformationGroupQueryService {
    @Override
    public List<InformationGroup> handle(GetAllInformationGroupsQuery query) {
        return List.of();
    }

    @Override
    public Optional<InformationGroup> handle(GetInformationGroupByIdQuery query) {
        return Optional.empty();
    }
}
