package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources;

public record UpdateProjectResource(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
}
