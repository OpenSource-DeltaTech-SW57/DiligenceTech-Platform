package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.*;
import com.deltetech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.Instant;
import java.util.Date;

@Getter
@Entity
public class DueDiligenceProject extends AuditableAbstractAggregateRoot<DueDiligenceProject> {

    @Embedded
    @AttributeOverride(name = "projectFullName", column = @Column(name = "project_name"))
    private ProjectName name;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "firstName", column = @Column(name = "manager_first_name")),
            @AttributeOverride(name = "lastName", column = @Column(name = "manager_last_name"))})
    private ProjectManagerName managerName;

    @Embedded
    private ProjectStartDate startDate;

    @Embedded
    private ProjectEndDate endDate;

    @Embedded
    private ProjectBudget budget;

    @Embedded
    private ProjectProgress progress;

    @Embedded
    private ProjectStatus status;

    @Embedded
    private final ProjectMember projectMember;

    public DueDiligenceProject() {
        this.projectMember = new ProjectMember();
    }

    public DueDiligenceProject(String projectFullName, String managerFirstName, String managerLastName, Date startDate, Date endDate, Float budget, Long progress, String status) {
        this.name = new ProjectName(projectFullName);
        this.managerName = new ProjectManagerName(managerFirstName, managerLastName);
        this.startDate = new ProjectStartDate(startDate);
        this.endDate = new ProjectEndDate(endDate);
        this.budget = new ProjectBudget(budget);
        this.progress = new ProjectProgress(progress);
        this.status = new ProjectStatus(status);
        this.projectMember = new ProjectMember();
    }

    public DueDiligenceProject(CreateDueDiligenceProjectCommand command) {
        this.name = new ProjectName(command.projectFullName());
        this.managerName = new ProjectManagerName(command.managerFirstName(), command.managerLastName());
        this.startDate = new ProjectStartDate(Date.from(Instant.parse(command.startDate())));
        this.endDate = new ProjectEndDate(Date.from(Instant.parse(command.endDate())));
        this.budget = new ProjectBudget(command.budget());
        this.progress = new ProjectProgress(command.progress());
        this.status = new ProjectStatus(command.status());
        this.projectMember = new ProjectMember();
    }

    public DueDiligenceProject updateProjectInformation(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
        this.name = new ProjectName(projectFullName);
        this.managerName = new ProjectManagerName(managerFirstName, managerLastName);
        this.startDate = new ProjectStartDate(Date.from(Instant.parse(startDate)));
        this.endDate = new ProjectEndDate(Date.from(Instant.parse(endDate)));
        this.budget = new ProjectBudget(budget);
        this.progress = new ProjectProgress(progress);
        this.status = new ProjectStatus(status);
        return this;
    }

    public void addMemberToProjectMember(AgentRecordId agentId) {
        this.projectMember.addProjectMemberItem(this, agentId);
    }
}
