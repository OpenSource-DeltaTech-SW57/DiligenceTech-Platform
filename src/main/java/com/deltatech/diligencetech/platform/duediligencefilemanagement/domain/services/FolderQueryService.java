package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface FolderQueryService {
  List<Folder> handle(GetFolderByAreaIdQuery query);
  Optional<Folder> handle(GetFolderByIdQuery query);
  List<Folder> handle(GetAllFoldersQuery query);
}
