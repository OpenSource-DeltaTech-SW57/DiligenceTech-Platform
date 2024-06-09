package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

public record UpdateProjectCommand(Long id, String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
}
