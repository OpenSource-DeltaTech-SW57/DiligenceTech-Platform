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
    public InformationGroupResource(Long id, String project_id, String identifier, String name, String parent, String buyStatus, String sellStatus) {
        this.id = id;
        this.project_id = project_id;
        this.identifier = identifier;
        this.name = name;
        this.parent = parent;
        this.buyStatus = buyStatus;
        this.sellStatus = sellStatus;
    }
}
