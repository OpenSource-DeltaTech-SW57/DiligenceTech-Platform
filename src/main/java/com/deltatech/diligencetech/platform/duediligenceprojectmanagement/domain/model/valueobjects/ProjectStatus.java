package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

public record ProjectStatus(String statusName) {
    public ProjectStatus() {this(null);}

    public String getProjectStatusName() {return statusName;}

    public ProjectStatus {
        if (statusName == null || statusName.isBlank()) {
            throw new IllegalArgumentException("Status name cannot be null or blank");
        }
    }
}
