package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.application.internal.outboundservices.acl.ExternalAgentService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.*;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRole;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectCommandService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.infrastructure.persistence.jpa.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectCommandServiceImpl implements ProjectCommandService {

    private final ProjectRepository projectRepository;
    private final ExternalAgentService externalAgentService;

    public ProjectCommandServiceImpl(ProjectRepository projectRepository, ExternalAgentService externalAgentService) {
        this.projectRepository = projectRepository;
        this.externalAgentService = externalAgentService;
    }

    @Override
    public Long handle(CreateProjectCommand command) {
        var dueDiligenceProject = new Project(command);
        // add a member for each agent on command
        command.buyAgents().forEach(buyAgent -> {
            if(buyAgent != null) {
                var agentIdByCode = externalAgentService.fetchAgentIdByCode(buyAgent);
                if(agentIdByCode.isEmpty()) throw new IllegalArgumentException("Agent does not exist");
            }
            dueDiligenceProject.addMemberToProjectMember(new AgentRecordId(buyAgent),  new AgentRole("BUY AGENT"));
        });
        command.sellAgents().forEach(sellAgent -> {
            if(sellAgent != null) {
                var agentIdByCode = externalAgentService.fetchAgentIdByCode(sellAgent);
                if(agentIdByCode.isEmpty()) throw new IllegalArgumentException("Agent does not exist");
            }
            dueDiligenceProject.addMemberToProjectMember(new AgentRecordId(sellAgent),  new AgentRole("SELL AGENT"));
        });
        try {
            projectRepository.save(dueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving due diligence project: " + e.getMessage());
        }
        return dueDiligenceProject.getId();
    }

    @Override
    public Optional<Project> handle(UpdateProjectNameCommand command) {
        var result = projectRepository.findById(command.id());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Due Diligence Project does not exist");
        }
        var dueDiligenceProjectToUpdate = result.get();
        try {
            var updatedDueDiligenceProject = projectRepository.save(dueDiligenceProjectToUpdate.updateProjectName(command.projectName()));
            return Optional.of(updatedDueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating due diligence project: " + e.getMessage());
        }
    }

    @Override
    public Optional<Project> handle(UpdateProjectBuyStatusCommand command) {
        var result = projectRepository.findById(command.id());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Due Diligence Project does not exist");
        }
        var dueDiligenceProjectToUpdate = result.get();
        try {
            var updatedDueDiligenceProject = projectRepository.save(dueDiligenceProjectToUpdate.updateProjectBuyStatus(command.buyStatus()));
            return Optional.of(updatedDueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating due diligence project: " + e.getMessage());
        }
    }

    @Override
    public Optional<Project> handle(UpdateProjectCompletedCommand command) {
        var result = projectRepository.findById(command.id());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Due Diligence Project does not exist");
        }
        var dueDiligenceProjectToUpdate = result.get();
        try {
            var updatedDueDiligenceProject = projectRepository.save(dueDiligenceProjectToUpdate.updateProjectCompleted(command.completed()));
            return Optional.of(updatedDueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating due diligence project: " + e.getMessage());
        }
    }

    @Override
    public Optional<Project> handle(UpdateProjectConfirmCommand command) {
        var result = projectRepository.findById(command.id());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Due Diligence Project does not exist");
        }
        var dueDiligenceProjectToUpdate = result.get();
        try {
            var updatedDueDiligenceProject = projectRepository.save(dueDiligenceProjectToUpdate.updateProjectConfirm(command.confirm()));
            return Optional.of(updatedDueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating due diligence project: " + e.getMessage());
        }
    }

    @Override
    public Optional<Project> handle(UpdateProjectSellStatusCommand command) {
        var result = projectRepository.findById(command.id());
        if(result.isEmpty()) {
            throw new IllegalArgumentException("Due Diligence Project does not exist");
        }
        var dueDiligenceProjectToUpdate = result.get();
        try {
            var updatedDueDiligenceProject = projectRepository.save(dueDiligenceProjectToUpdate.updateProjectName(command.sellStatus()));
            return Optional.of(updatedDueDiligenceProject);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while updating due diligence project: " + e.getMessage());
        }
    }

    public Optional<Project> handle(UpdateProjectCommand command) {
       var result = projectRepository.findById(command.id());
       if(result.isEmpty()) {
           throw new IllegalArgumentException("Due Diligence Project does not exist");
       }
       var dueDiligenceProjectToUpdate = result.get();
       try {
           var updatedDueDiligenceProject = projectRepository.save(dueDiligenceProjectToUpdate.updateProjec(command.projectName(), command.buyStatus(), command.sellStatus(), command.completed(), command.confirm()));
           return Optional.of(updatedDueDiligenceProject);
       } catch (Exception e) {
           throw new IllegalArgumentException("Error while updating due diligence project");
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
        if(command.agentId().agentRecordId() != null) {
            var agentIdByCode = externalAgentService.fetchAgentIdByCode(command.agentId().agentRecordId());
            if(agentIdByCode.isEmpty()) throw new IllegalArgumentException("Agent does not exist");
            //if(!agentIdByCode.get().equals(agentIdByEmail.get())) throw new IllegalArgumentException("Agent does not exist");
        }
        try {
            projectRepository.findById(command.projectId()).map(dueDiligenceProject -> {
                //dueDiligenceProject.addMemberToProjectMember(command.agentId(), command.agentEmail(), command.agentRole());
                dueDiligenceProject.addMemberToProjectMember(command.agentId(), command.agentRole());
                projectRepository.save(dueDiligenceProject);
                System.out.println("Member added to Project Member");
                return dueDiligenceProject;
            });
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while adding member to project member: " + e.getMessage());
        }
    }
}