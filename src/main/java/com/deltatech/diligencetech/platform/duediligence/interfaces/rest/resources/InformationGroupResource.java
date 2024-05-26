package com.deltatech.diligencetech.platform.duediligence.interfaces.rest.resources;

public record InformationGroupResource(
        Long id,
        String project_id,
        String identifier,
        String name,
        String parent,
        String buyStatus,
        String sellStatus
    ) {
}
