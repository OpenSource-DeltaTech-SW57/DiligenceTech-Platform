package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Folder;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.*;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.AreaQueryService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.FolderQueryService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.AreaRepository;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FolderQueryServiceImpl implements FolderQueryService {
  private final FolderRepository folderRepository;
  private final AreaRepository areaRepository;

  public FolderQueryServiceImpl(FolderRepository folderRepository, AreaRepository areaRepository) {
    this.folderRepository = folderRepository;
    this.areaRepository = areaRepository;
  }


  @Override
  public List<Folder> handle(GetFolderByAreaIdQuery query) {
    var area = areaRepository.findById(query.areaId());
    if(area.isEmpty()) throw new IllegalArgumentException("Area does not exist");
    return folderRepository.findByParent(area.get());

  }

  @Override
  public Optional<Folder> handle(GetFolderByIdQuery query) {
    return folderRepository.findById(query.folderId());
  }

  @Override
  public List<Folder> handle(GetAllFoldersQuery query) {
    return folderRepository.findAll();
  }
}
