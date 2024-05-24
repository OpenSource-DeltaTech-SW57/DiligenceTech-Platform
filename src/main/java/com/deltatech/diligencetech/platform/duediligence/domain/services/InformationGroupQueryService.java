package com.deltatech.diligencetech.platform.duediligence.domain.services;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllInformationGroupsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetInformationGroupByIdQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetInformationGroupsByParentQuery;

import java.util.List;
import java.util.Optional;

public interface InformationGroupQueryService {
    List<InformationGroup> handle(GetAllInformationGroupsQuery query);
    Optional<InformationGroup> handle(GetInformationGroupByIdQuery query);
    List<InformationGroup> handle(GetInformationGroupsByParentQuery query);
}
