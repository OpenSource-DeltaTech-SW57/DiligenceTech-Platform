package com.deltatech.diligencetech.platform.duediligence.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Document;
import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateDocumentCommand;
import com.deltatech.diligencetech.platform.duediligence.domain.services.DocumentCommandService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentCommandServiceImpl implements DocumentCommandService {
    @Override
    public Optional<Document> handle(CreateDocumentCommand command) {
        return Optional.empty();
    }
}
