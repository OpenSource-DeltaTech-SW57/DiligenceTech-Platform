package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateAreaCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateAreaNameCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import java.util.Optional;

public interface AreaCommandService {
  Long handle(CreateAreaCommand command);
  Optional<Area> handle(UpdateAreaNameCommand command);
}
