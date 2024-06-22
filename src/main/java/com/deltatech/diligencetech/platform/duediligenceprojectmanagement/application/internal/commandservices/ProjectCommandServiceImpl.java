package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.application.internal.outboundservices.acl.ExternalAgentService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.AddMemberToProjectMemberCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateProjectCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.DeleteProjectCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.UpdateProjectCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectCommandService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.infrastructure.persistence.jpa.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectCommandServiceImpl implements ProjectCommandService {

    private final ProjectRepository projectRepository;

  public ProjectCommandServiceImpl(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }


  @Override
    public Long handle(CreateProjectCommand command) {

        var dueDiligenceProject = new Project(command);
        try {
            projectRepository.save(dueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving due diligence project: " + e.getMessage());
        }
        return dueDiligenceProject.getId();
    }

    @Override
    public Optional<Project> handle(UpdateProjectCommand command) {
        var result = projectRepository.findById(command.id());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Due Diligence Project does not exist");
        }
        var dueDiligenceProjectToUpdate = result.get();
        try {
            var updatedDueDiligenceProject = projectRepository.save(dueDiligenceProjectToUpdate.updateProjectInformation(
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
    public void handle(DeleteProjectCommand command) {
        if(!projectRepository.existsById(command.projectId())) {
            throw new IllegalArgumentException("Due diligence project does not exist");
        }
        try {
            projectRepository.deleteById(command.projectId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting due diligence project: " + e.getMessage());
        }
    }

    @Override
    public void handle(AddMemberToProjectMemberCommand command) {
        if(!projectRepository.existsById(command.projectId())) {
            throw new IllegalArgumentException("Due diligence project does not exist");
        }
        try {
            projectRepository.findById(command.projectId()).map(dueDiligenceProject -> {
                dueDiligenceProject.addMemberToProjectMember(command.agentId(), command.agentEmail(), command.agentRole());
                projectRepository.save(dueDiligenceProject);
                System.out.println("Member added to Project Member");
                return dueDiligenceProject;
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while adding member to project member: " + e.getMessage());
        }
    }
}