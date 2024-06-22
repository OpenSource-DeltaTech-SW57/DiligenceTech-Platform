package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities.ProjectMemberItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class ProjectMember {

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<ProjectMemberItem> projectMemberItems;

    public ProjectMember() {
        this.projectMemberItems = new ArrayList<>();
    }

    public void addProjectMemberItem(Project project, AgentRecordId agentRecordId, AgentEmail agentEmail, AgentRole agentRole) {
        System.out.println("Adding item to project member");
        ProjectMemberItem projectMemberItem = new ProjectMemberItem(project, agentRecordId, agentEmail, agentRole);
        System.out.println("Project Id" + projectMemberItem.getProject().getId());
        System.out.println("Agent Id" + projectMemberItem.getAgentRecordId());
        projectMemberItems.add(projectMemberItem);
    }

    public ProjectMemberItem getProjectMemberItemWithId(Long itemId) {
        return projectMemberItems.stream().filter(projectMemberItem -> projectMemberItem.getId().equals(itemId))
                .findFirst().orElse(null);
    }

    public List<ProjectMemberItem> getAllProjectMemberItems() {
        return new ArrayList<>(projectMemberItems);
    }

    public ProjectMemberItem getProjectMemberItemWithAgentRecordId(AgentRecordId agentId) {
        return projectMemberItems.stream().filter(projectMemberItem -> projectMemberItem.getAgentRecordId().equals(agentId))
                .findFirst().orElse(null);
    }

    public boolean isEmpty() { return projectMemberItems.isEmpty();}
}
