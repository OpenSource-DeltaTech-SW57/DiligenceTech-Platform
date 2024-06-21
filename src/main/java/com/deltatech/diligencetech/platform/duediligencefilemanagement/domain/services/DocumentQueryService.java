package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.entities.Document;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface DocumentQueryService {
  List<Document> handle(GetDocumentsByFolderIdQuery query);
  Optional<Document> handle(GetDocumentByIdQuery query);
  List<Document> handle(GetAllDocumentsQuery query);
}
