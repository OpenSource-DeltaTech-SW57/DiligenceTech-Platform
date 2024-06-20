package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.commandservices;

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

  public AreaCommandServiceImpl(AreaRepository areaRepository) {
    this.areaRepository = areaRepository;
  }

  @Override
  public Long handle(CreateAreaCommand command) {
    if (areaRepository.existsByCode(command.code())) {
      throw new IllegalArgumentException("Area with same code already exists");
    }
    var agent = new Area(command);
    try {
      areaRepository.save(agent);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while saving area: " + e.getMessage());
    }
    return agent.getId();
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
