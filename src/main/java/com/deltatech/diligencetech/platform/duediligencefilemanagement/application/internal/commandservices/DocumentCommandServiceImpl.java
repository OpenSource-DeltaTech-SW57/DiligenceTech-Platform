package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.CreateDocumentCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.DeleteDocumentCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.UpdateDocumentCommand;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.entities.Document;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services.DocumentCommandService;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.DocumentRepository;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories.FolderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentCommandServiceImpl implements DocumentCommandService {
  private final DocumentRepository documentRepository;
  private final FolderRepository folderRepository;

  public DocumentCommandServiceImpl(DocumentRepository documentRepository, FolderRepository folderRepository) {
    this.documentRepository = documentRepository;
    this.folderRepository = folderRepository;
  }

  @Override
  public Long handle(CreateDocumentCommand command) {
    var document = new Document(command);
    var folder = folderRepository.findById(command.folderId());
    if (folder.isEmpty()) throw new IllegalArgumentException("Folder does not exist");
    document.insertFolder(folder.get());
    try {
      documentRepository.save(document);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while saving document: " + e.getMessage());
    }
    return document.getId();
  }

  @Override
  public Optional<Document> handle(UpdateDocumentCommand command) {
    var result = documentRepository.findById(command.id());
    if (result.isEmpty()) throw new IllegalArgumentException("Document does not exist");
    var documentToUpdate = result.get();
    try {
      var updatedDocument = documentRepository.save(documentToUpdate.updateName(command.filename()));
      return Optional.of((Document) updatedDocument);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while updating document: " + e.getMessage());
    }
  }

  @Override
  public void handle(DeleteDocumentCommand command) {
    var result = documentRepository.findById(command.documentId());
    if (result.isEmpty()) throw new IllegalArgumentException("Document does not exist");
    var documentToDelete = result.get();
    try {
      documentRepository.delete(documentToDelete);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while deleting document: " + e.getMessage());
    }
  }
}
