package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.entities.Document;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.*;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.DocumentQueryService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.DocumentRepository;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentQueryServiceImpl implements DocumentQueryService {

  private final DocumentRepository documentRepository;
  private final FolderRepository folderRepository;

  public DocumentQueryServiceImpl(DocumentRepository documentRepository, FolderRepository folderRepository) {
    this.documentRepository = documentRepository;
    this.folderRepository = folderRepository;
  }


  @Override
  public List<Document> handle(GetDocumentsByFolderIdQuery query) {
    var folder = folderRepository.findById(query.folderId());
    if (folder.isEmpty()) throw new IllegalArgumentException("Folder does not exist");
    return documentRepository.findByFolder(folder.get());
  }

  @Override
  public Optional<Document> handle(GetDocumentByIdQuery query) {
    return documentRepository.findById(query.documentId());
  }

  @Override
  public List<Document> handle(GetAllDocumentsQuery query) {
    return documentRepository.findAll();
  }

}
