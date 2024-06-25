package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

//old
//public record CreateProjectCommand(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
//}
//new
public record CreateProjectCommand(String projectFullName) {
}