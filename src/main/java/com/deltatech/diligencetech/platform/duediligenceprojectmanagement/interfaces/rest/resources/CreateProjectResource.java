package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources;

import java.util.List;

//old
//public record CreateProjectResource(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
//}
//new
public record CreateProjectResource(String projectName, List<String> buyAgents, List<String> sellAgents) {
}
