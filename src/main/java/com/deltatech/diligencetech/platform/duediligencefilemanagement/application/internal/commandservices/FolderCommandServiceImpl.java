package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.commandservices;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateFolderCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateFolderNameCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.FolderCommandService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FolderCommandServiceImpl implements FolderCommandService {
  private final FolderRepository folderRepository;

  public FolderCommandServiceImpl(FolderRepository folderRepository) {
    this.folderRepository = folderRepository;
  }

  @Override
  public Long handle(CreateFolderCommand command) {
    if (folderRepository.existsByCode(command.code())) {
      throw new IllegalArgumentException("Folder with the same code already exists");
    }
    var folder = new Folder(command);
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
