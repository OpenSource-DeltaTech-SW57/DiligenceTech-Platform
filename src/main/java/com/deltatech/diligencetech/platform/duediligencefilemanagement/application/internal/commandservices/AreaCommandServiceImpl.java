package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.outboundservices.acl.ExternalProjectService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateAreaCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateAreaNameCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.AreaCommandService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.AreaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AreaCommandServiceImpl implements AreaCommandService {
  private final AreaRepository areaRepository;
  private final ExternalProjectService externalProjectService;


  public AreaCommandServiceImpl(AreaRepository areaRepository, ExternalProjectService externalProjectService) {
    this.areaRepository = areaRepository;
    this.externalProjectService = externalProjectService;
  }

  @Override
  public Long handle(CreateAreaCommand command) {
    if (areaRepository.existsByName(command.name())) {
      throw new IllegalArgumentException("Area with the same name already exists");
    }
    if (command.projectId() != null) {
      var projectId = externalProjectService.fetchProjectIdById(command.projectId());
      if (projectId.isEmpty()) throw new IllegalArgumentException("Project does not exist");
    }
    var area = new Area(command);
    try {
      areaRepository.save(area);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while saving area: " + e.getMessage());
    }
    return area.getId();
  }

  @Override
  public Optional<Area> handle(UpdateAreaNameCommand command) {
    var result = areaRepository.findById(command.id());
    if (result.isEmpty()) throw new IllegalArgumentException("Area does not exist");
    var areaToUpdate = result.get();
    try {
      var updatedArea = areaRepository.save(areaToUpdate.updateName(command.name()));
      return Optional.of((Area) updatedArea);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while updating area: " + e.getMessage());
    }
  }



}
