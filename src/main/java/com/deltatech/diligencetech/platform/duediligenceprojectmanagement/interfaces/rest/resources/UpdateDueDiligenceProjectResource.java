package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources;

import java.util.Date;

public record UpdateDueDiligenceProjectResource(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
}
