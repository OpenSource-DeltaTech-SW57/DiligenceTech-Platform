package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateAreaCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateDocumentCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.CreateAreaResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.CreateDocumentResource;

public class CreateDocumentCommandFromResourceAssembler {
  public static CreateDocumentCommand toCommandFromResource(CreateDocumentResource resource) {
    return new CreateDocumentCommand(resource.projectId(), resource.filename(), resource.fileUrl());
  }
}
