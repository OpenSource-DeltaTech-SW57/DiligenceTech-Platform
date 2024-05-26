package com.deltatech.diligencetech.platform.duediligence.domain.services;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Document;
import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateDocumentCommand;

import java.util.Optional;

public interface DocumentCommandService {
    Optional<Document> handle(CreateDocumentCommand command);
}
