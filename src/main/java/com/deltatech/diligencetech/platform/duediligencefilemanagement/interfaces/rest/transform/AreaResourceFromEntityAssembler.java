package com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.transform;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.interfaces.rest.resources.AreaResource;

public class AreaResourceFromEntityAssembler {
  public static AreaResource toResourceFromEntity(Area entity) {
    return new AreaResource(entity.getId(), entity.getProjectId(), entity.getName());
  }
}
