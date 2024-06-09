package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources;

public record CreateDueDiligenceProjectResource(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
}
