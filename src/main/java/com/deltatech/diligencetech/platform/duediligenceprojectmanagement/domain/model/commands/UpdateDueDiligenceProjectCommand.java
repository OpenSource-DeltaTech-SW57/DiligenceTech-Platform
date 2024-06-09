package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands;

import java.util.Date;

public record UpdateDueDiligenceProjectCommand(Long id, String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
}
