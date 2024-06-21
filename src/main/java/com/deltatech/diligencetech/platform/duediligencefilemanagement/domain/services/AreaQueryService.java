package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAllAreasQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAreaByIdQuery;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.GetAreasByProjectIdQuery;

import java.util.List;
import java.util.Optional;

public interface AreaQueryService {
  List<Area> handle(GetAreasByProjectIdQuery query);
  Optional<Area> handle(GetAreaByIdQuery query);
  List<Area> handle(GetAllAreasQuery query);

}
