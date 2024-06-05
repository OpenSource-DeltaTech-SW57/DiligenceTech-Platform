package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAllAreasQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAreaByIdQuery;

import java.util.List;
import java.util.Optional;

public interface AreaQueryService {
    List<Area> handle(GetAllAreasQuery query);
    Optional<Area> handle(GetAreaByIdQuery query);
}
