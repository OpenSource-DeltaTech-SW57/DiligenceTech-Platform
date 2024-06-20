package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateAreaNameCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateFolderNameCommand;

public class UpdateFolderNameCommandFromResourceAssembler {
  public static UpdateFolderNameCommand toCommandFromResource(Long folderId, String name) {
    return new UpdateFolderNameCommand(folderId, name);
  }
}
