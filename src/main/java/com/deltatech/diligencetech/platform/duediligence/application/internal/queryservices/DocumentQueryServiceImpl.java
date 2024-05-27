package com.deltatech.diligencetech.platform.duediligence.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Document;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllDocumentsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetDocumentByIdQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.services.DocumentQueryService;
import com.deltatech.diligencetech.platform.duediligence.infrastructure.persistence.jpa.repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentQueryServiceImpl implements DocumentQueryService {
    private final DocumentRepository documentRepository;

    public DocumentQueryServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Document> handle(GetAllDocumentsQuery query) {
        return documentRepository.findAll();
    }

    @Override
    public Optional<Document> handle(GetDocumentByIdQuery query) {
        return documentRepository.findById(query.id());
    }
}
