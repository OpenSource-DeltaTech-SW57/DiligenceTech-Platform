package com.deltatech.diligencetech.platform.duediligence.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Document;
import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateDocumentCommand;
import com.deltatech.diligencetech.platform.duediligence.domain.services.DocumentCommandService;
import com.deltatech.diligencetech.platform.duediligence.infrastructure.persistence.jpa.repositories.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentCommandServiceImpl implements DocumentCommandService {
    private final DocumentRepository documentRepository;

    public DocumentCommandServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Optional<Document> handle(CreateDocumentCommand command) {
        var document = new Document(command);
        var createdDocument = documentRepository.save(document);
        return Optional.of(createdDocument);
    }
}
