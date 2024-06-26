package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.*;

import java.util.Optional;

public interface ProjectCommandService {
    Long handle(CreateProjectCommand command);
    Optional<Project> handle(UpdateProjectNameCommand command);
    Optional<Project> handle(UpdateProjectBuyStatusCommand command);
    Optional<Project> handle(UpdateProjectSellStatusCommand command);
    Optional<Project> handle(UpdateProjectCompletedCommand command);
    Optional<Project> handle(UpdateProjectConfirmCommand command);
    void handle(DeleteProjectCommand command);
    void handle(AddMemberToProjectMemberCommand command);
    Optional<Project> handle(UpdateProjectCommand command);
}
