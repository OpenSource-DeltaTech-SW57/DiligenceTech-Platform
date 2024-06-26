package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

public record UpdateProjectCommand(Long id, String projectName, String buyStatus, String sellStatus, Boolean completed, Boolean confirm) {
}
