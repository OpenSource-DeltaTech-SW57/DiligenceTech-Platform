package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

public record CreateDueDiligenceProjectCommand(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
}
