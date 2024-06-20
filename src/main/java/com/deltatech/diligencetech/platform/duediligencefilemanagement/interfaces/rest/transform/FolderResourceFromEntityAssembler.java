package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.AreaResource;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.FolderResource;

public class FolderResourceFromEntityAssembler {
  public static FolderResource toResourceFromEntity(Folder entity) {
    return new FolderResource(entity.getId(), entity.getFolderData().name(), entity.getFolderData().obligatory());
  }
}
