package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands.*;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.entities.Document;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.DeleteProjectCommand;


import java.util.Optional;

public interface DocumentCommandService {
  Long handle(CreateDocumentCommand command);
  Optional<Document> handle(UpdateDocumentCommand command);
  void handle(DeleteDocumentCommand command);
}
