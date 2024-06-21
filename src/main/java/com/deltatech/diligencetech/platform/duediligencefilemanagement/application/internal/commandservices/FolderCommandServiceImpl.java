package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.commandservices;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateFolderCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateFolderNameCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.FolderCommandService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.AreaRepository;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FolderCommandServiceImpl implements FolderCommandService {
  private final FolderRepository folderRepository;
  private final AreaRepository areaRepository;

  public FolderCommandServiceImpl(FolderRepository folderRepository, AreaRepository areaRepository) {
    this.folderRepository = folderRepository;
    this.areaRepository = areaRepository;
  }

  @Override
  public Long handle(CreateFolderCommand command) {
    var folder = new Folder(command);
    var area = areaRepository.findById(command.areaId());
    if (area.isEmpty()) throw new IllegalArgumentException("Area does not exist");
    folder.insertParent(area.get());
    try {
      folderRepository.save(folder);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while saving folder: " + e.getMessage());
    }
    return folder.getId();
  }

  @Override
  public Optional<Folder> handle(UpdateFolderNameCommand command) {
    var result = folderRepository.findById(command.id());
    if (result.isEmpty()) throw new IllegalArgumentException("Folder does not exist");
    var folderToUpdate = result.get();
    try {
      var updatedArea = folderRepository.save(folderToUpdate.updateName(command.name()));
      return Optional.of((Folder) updatedArea);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while updating folder: " + e.getMessage());
    }
  }

}
