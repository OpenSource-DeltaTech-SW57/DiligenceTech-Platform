package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateAreaCommand;

import java.util.Optional;

public interface AreaCommandService {
    Optional<Area> handle(CreateAreaCommand command);
}
