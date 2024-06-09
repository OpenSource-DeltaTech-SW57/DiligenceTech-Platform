package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.DueDiligenceProject;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.AddMemberToProjectMemberCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.DeleteDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateDueDiligenceProjectCommand;

import java.util.Optional;

public interface DueDiligenceProjectCommandService {
    Long handle(CreateDueDiligenceProjectCommand command);
    Optional<DueDiligenceProject> handle(UpdateDueDiligenceProjectCommand command);
    void handle(DeleteDueDiligenceProjectCommand command);
    void handle(AddMemberToProjectMemberCommand command);
}
