package com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources;

public record DocumentResource(
        Long id,
        String projectId,
        String informationGroupId,
        String fileName,
        String fileUrl
    ) {
}
