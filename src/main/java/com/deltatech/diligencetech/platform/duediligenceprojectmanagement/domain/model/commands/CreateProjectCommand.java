package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

import java.util.List;

//old
//public record CreateProjectCommand(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
//}
//new
public record CreateProjectCommand(String projectFullName, List<String> buyAgents, List<String> sellAgents) {
}
