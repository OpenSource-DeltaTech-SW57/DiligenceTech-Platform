package com.deltatech.diligencetech.platform.duediligence.interfaces.rest.transform;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Document;
import com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources.DocumentResource;

public class DocumentResourceFromEntityAssembler {
    public static DocumentResource toResourceFromEntity(Document entity) {
        return new DocumentResource(
                entity.getId(),
                null,
                null,
                entity.getFileName(),
                entity.getFileUrl()
        );
    }
}
