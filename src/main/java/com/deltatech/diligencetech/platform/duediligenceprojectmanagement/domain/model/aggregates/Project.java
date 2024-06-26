package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateProjectCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.*;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Project extends AuditableAbstractAggregateRoot<Project> {

    @Embedded
    @AttributeOverride(name = "projectFullName", column = @Column(name = "project_name"))
    private ProjectName name;

    @Embedded
    private ProjectBuyStatus buyStatus;

    @Getter
    @Column
    private Boolean completed;

    @Getter
    @Column
    private Boolean confirm;

    @Embedded
    private ProjectSellStatus sellStatus;

    @Embedded
    private final ProjectMember projectMember;

    public Project() {
        this.projectMember = new ProjectMember();
    }

    // In progress
    // done
    // None
    public Project(String projectFullName) {
        this.name = new ProjectName(projectFullName);
        this.buyStatus = new ProjectBuyStatus("NONE");
        this.sellStatus = new ProjectSellStatus("NONE");
        this.completed = false;
        this.confirm = false;
        this.projectMember = new ProjectMember();
    }

    public Project(CreateProjectCommand command) {
        this.name = new ProjectName(command.projectFullName());
        this.buyStatus = new ProjectBuyStatus("NONE");
        this.sellStatus = new ProjectSellStatus("NONE");
        this.completed = false;
        this.confirm = false;
        this.projectMember = new ProjectMember();
    }

    public Project updateProjectInformation(String projectFullName) {
        this.name = new ProjectName(projectFullName);
        return this;
    }

    //public void addMemberToProjectMember(AgentRecordId agentId, AgentEmail agentEmail, AgentRole agentRole) {
    //    this.projectMember.addProjectMemberItem(this, agentId, agentEmail, agentRole);
    //}

    public void addMemberToProjectMember(AgentRecordId agentId, AgentRole agentRole) {
        this.projectMember.addProjectMemberItem(this, agentId, agentRole);
    }
}