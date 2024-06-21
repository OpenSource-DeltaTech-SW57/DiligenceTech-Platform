package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateFolderCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateFolderNameCommand;

import java.util.Optional;

public interface FolderCommandService {
  Long handle(CreateFolderCommand command);
  Optional<Folder> handle(UpdateFolderNameCommand command);

}
