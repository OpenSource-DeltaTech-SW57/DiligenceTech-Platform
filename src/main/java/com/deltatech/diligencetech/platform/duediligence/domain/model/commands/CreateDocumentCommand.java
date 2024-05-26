package com.deltatech.diligencetech.platform.duediligence.domain.model.commands;

public record CreateDocumentCommand(
        String fileName,
        String fileUrl
        ) {
}
