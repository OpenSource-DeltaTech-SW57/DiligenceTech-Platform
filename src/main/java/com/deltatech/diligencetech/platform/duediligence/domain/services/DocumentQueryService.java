package com.deltatech.diligencetech.platform.duediligence.domain.services;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Document;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllDocumentsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetDocumentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface DocumentQueryService {
    List<Document> handle(GetAllDocumentsQuery query);
    Optional<Document> handle(GetDocumentByIdQuery query);
}
