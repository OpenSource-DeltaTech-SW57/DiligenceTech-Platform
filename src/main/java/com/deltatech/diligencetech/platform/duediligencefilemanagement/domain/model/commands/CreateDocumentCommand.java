package com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.commands;

public record CreateDocumentCommand(Long folderId, String filename, String fileUrl) {
}
