package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

//old
//public record UpdateProjectCommand(Long id, String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
//}
//new
public record UpdateProjectNameCommand(Long id, String projectName) {
}
