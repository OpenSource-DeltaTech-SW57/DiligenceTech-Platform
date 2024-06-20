package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.*;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.AreaQueryService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.FolderQueryService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.AreaRepository;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.FolderRepository;

import java.util.List;
import java.util.Optional;

public class FolderQueryServiceImpl implements FolderQueryService {
  private final FolderQueryService folderQueryService;
  private final FolderRepository folderRepository;

  public FolderQueryServiceImpl(FolderQueryService folderQueryService, FolderRepository folderRepository) {
    this.folderQueryService = folderQueryService;
    this.folderRepository = folderRepository;
  }

  @Override
  public Optional<Folder> handle(GetFolderByAreaIdQuery query) {
    return folderRepository.findById(query.areaId());
  }

  @Override
  public Optional<Folder> handle(GetFolderByIdQuery query) {
    return folderRepository.findByCode(query.folderId());
  }

  @Override
  public List<Folder> handle(GetAllFoldersQuery query) {
    return folderRepository.findAll();
  }
}
