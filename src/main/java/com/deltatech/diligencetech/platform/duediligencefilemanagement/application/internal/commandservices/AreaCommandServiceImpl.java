package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateAreaCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.AreaCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AreaCommandServiceImpl implements AreaCommandService {
    @Override
    public Optional<Area> handle(CreateAreaCommand command) {
        return Optional.empty();
    }
}
