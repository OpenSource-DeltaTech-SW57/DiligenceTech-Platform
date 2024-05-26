package com.deltatech.diligencetech.platform.duediligence.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Document;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetAllDocumentsQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.model.queries.GetDocumentByIdQuery;
import com.deltatech.diligencetech.platform.duediligence.domain.services.DocumentQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentQueryServiceImpl implements DocumentQueryService {
    @Override
    public List<Document> handle(GetAllDocumentsQuery query) {
        return List.of();
    }

    @Override
    public Optional<Document> handle(GetDocumentByIdQuery query) {
        return Optional.empty();
    }
}
