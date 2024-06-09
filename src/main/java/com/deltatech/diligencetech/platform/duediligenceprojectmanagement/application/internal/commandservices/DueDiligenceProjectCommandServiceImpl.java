package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.application.internal.commandservices;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.DueDiligenceProject;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.AddMemberToProjectMemberCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.DeleteDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services.DueDiligenceProjectCommandService;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.infrastructure.persistence.jpa.repositories.DueDiligenceProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DueDiligenceProjectCommandServiceImpl implements DueDiligenceProjectCommandService {

    private final DueDiligenceProjectRepository dueDiligenceProjectRepository;

    public DueDiligenceProjectCommandServiceImpl(DueDiligenceProjectRepository dueDiligenceProjectRepository) {
        this.dueDiligenceProjectRepository = dueDiligenceProjectRepository;
    }

    @Override
    public Long handle(CreateDueDiligenceProjectCommand command) {
        var dueDiligenceProject = new DueDiligenceProject(command);
        try {
            dueDiligenceProjectRepository.save(dueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving due diligence project: " + e.getMessage());
        }
        return dueDiligenceProject.getId();
    }

    @Override
    public Optional<DueDiligenceProject> handle(UpdateDueDiligenceProjectCommand command) {
        var result = dueDiligenceProjectRepository.findById(command.id());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Due Diligence Project does not exist");
        }
        var dueDiligenceProjectToUpdate = result.get();
        try {
            var updatedDueDiligenceProject = dueDiligenceProjectRepository.save(dueDiligenceProjectToUpdate.updateProjectInformation(
                    command.projectFullName(),
                    command.managerFirstName(),
                    command.managerLastName(),
                    command.startDate(),
                    command.endDate(),
                    command.budget(),
                    command.progress(),
                    command.status()));
            return Optional.of(updatedDueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating due diligence project: " + e.getMessage());
        }
    }

    @Override
    public void handle(DeleteDueDiligenceProjectCommand command) {
        if(!dueDiligenceProjectRepository.existsById(command.projectId())) {
            throw new IllegalArgumentException("Due diligence project does not exist");
        }
        try {
            dueDiligenceProjectRepository.deleteById(command.projectId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting due diligence project: " + e.getMessage());
        }
    }

    @Override
    public void handle(AddMemberToProjectMemberCommand command) {
        if(!dueDiligenceProjectRepository.existsById(command.projectId())) {
            throw new IllegalArgumentException("Due diligence project does not exist");
        }
        try {
            dueDiligenceProjectRepository.findById(command.projectId()).map(dueDiligenceProject -> {
              dueDiligenceProject.addMemberToProjectMember(command.agentId());
              dueDiligenceProjectRepository.save(dueDiligenceProject);
              System.out.println("Member added to Project Member");
              return dueDiligenceProject;
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while adding member to project member: " + e.getMessage());
        }
    }
}
