package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateAreaCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateFolderCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.CreateAreaResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.CreateFolderResource;

public class CreateFolderCommandFromResourceAssembler {
  public static CreateFolderCommand toCommandFromResource(CreateFolderResource resource) {
    return new CreateFolderCommand(resource.areaId(), resource.name());
  }
}
