package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.DueDiligenceProject;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities.ProjectMemberItem;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class ProjectMember {

    @OneToMany(mappedBy = "dueDiligenceProject", cascade = CascadeType.ALL)
    private List<ProjectMemberItem> projectMemberItems;

    public ProjectMember() {
        this.projectMemberItems = new ArrayList<>();
    }

    public void addProjectMemberItem(DueDiligenceProject dueDiligenceProject, AgentRecordId agentRecordId) {
        System.out.println("Adding item to project member");
        ProjectMemberItem projectMemberItem = new ProjectMemberItem(dueDiligenceProject, agentRecordId);
        System.out.println("Project Id" + projectMemberItem.getDueDiligenceProject().getId());
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
