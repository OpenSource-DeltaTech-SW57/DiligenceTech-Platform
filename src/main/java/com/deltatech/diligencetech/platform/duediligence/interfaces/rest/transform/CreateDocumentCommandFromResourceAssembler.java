package com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateDocumentCommand;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources.DocumentResource;

public class CreateDocumentCommandFromResourceAssembler {
    public static CreateDocumentCommand toCommandFromResource(DocumentResource resource) {
        return new CreateDocumentCommand(
                resource.fileName(),
                resource.fileUrl()
        );
    }
}
