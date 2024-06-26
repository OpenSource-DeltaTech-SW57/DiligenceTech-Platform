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

    public Project updateProjectName (String projectName) {
        this.name = new ProjectName(projectName);
        return this;
    }

    public Project updateProjectBuyStatus(String buyStatus) {
        this.buyStatus = new ProjectBuyStatus(buyStatus);
       return this;
    }

    public Project updateProjectCompleted(Boolean completed) {
        this.completed = completed;
        return this;
    }

    public Project updateProjectConfirm(Boolean confirm) {
        this.confirm = confirm;
        return this;
    }

    public Project updateProjectSellStatus(String sellStatus) {
        this.sellStatus = new ProjectSellStatus(sellStatus);
        return this;
    }

    public Project updateProjec(String name, String buyStatus, String sellStatus, Boolean completed, Boolean confirm) {
        this.name = new ProjectName(name);
        this.buyStatus = new ProjectBuyStatus(buyStatus);
        this.sellStatus = new ProjectSellStatus(sellStatus);
        this.completed = completed;
        this.confirm = confirm;
        return this;
    }

    //public void addMemberToProjectMember(AgentRecordId agentId, AgentEmail agentEmail, AgentRole agentRole) {
    //    this.projectMember.addProjectMemberItem(this, agentId, agentEmail, agentRole);
    //}

    public void addMemberToProjectMember(AgentRecordId agentId, AgentRole agentRole) {
        this.projectMember.addProjectMemberItem(this, agentId, agentRole);
    }
}