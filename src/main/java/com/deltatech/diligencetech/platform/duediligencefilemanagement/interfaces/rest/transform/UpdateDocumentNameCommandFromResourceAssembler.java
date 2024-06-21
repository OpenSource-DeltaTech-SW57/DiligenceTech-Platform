package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateDocumentCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateFolderNameCommand;

public class UpdateDocumentNameCommandFromResourceAssembler {
  public static UpdateDocumentCommand toCommandFromResource(Long documentId, String filename) {
    return new UpdateDocumentCommand(documentId, filename);
  }
}
