package com.deltatech.diligencetech.platform.profiles.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectQueryService;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.AgentProjectResource;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.DashboardResource;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform.ProjectResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/agents/{agentRecordId}/due-diligence-projects", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Agents")
public class AgentProjectController {
    private final ProjectQueryService projectQueryService;

    public AgentProjectController(ProjectQueryService projectQueryService) {
        this.projectQueryService = projectQueryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<AgentProjectResource>> getAllProjectsLinkedToAgent(@PathVariable String agentRecordId) {
        var deltaAgentRecordId = new AgentRecordId(agentRecordId);
        var dueDiligenceProjects = new GetAllProjectsQuery();
        var projects =  projectQueryService.handle(dueDiligenceProjects);
        var agentIncludedProjects = projects.stream()
                .filter(project -> project.getProjectMember().getAllProjectMemberItems().stream()
                        .anyMatch(projectMemberItem -> projectMemberItem.getAgentRecordId().equals(deltaAgentRecordId)))
                .toList();
        var agentProjectResources = agentIncludedProjects.stream().map(ProjectResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(agentProjectResources);
    }

    @GetMapping("/all-sellside")
    public ResponseEntity<List<AgentProjectResource>> getAllProjectsLinkedToAgentSellSide(@PathVariable String agentRecordId) {
        var sellAgentRecordId = new AgentRecordId(agentRecordId);
        var dueDiligenceProjects = new GetAllProjectsQuery();
        var projects =  projectQueryService.handle(dueDiligenceProjects);
        var agentIncludedProjects = projects.stream()
                .filter(project -> project.getProjectMember().getAllProjectMemberItems().stream()
                        .anyMatch(projectMemberItem -> projectMemberItem.getAgentRecordId().equals(sellAgentRecordId)
                            && projectMemberItem.getAgentRole().agentRole().equals("SELL AGENT")))
                .toList();
        var agentProjectResources = agentIncludedProjects.stream().map(ProjectResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(agentProjectResources);
    }

    @GetMapping("/all-buyside")
    public ResponseEntity<List<AgentProjectResource>> getAllProjectsLinkedToAgentBuySide(@PathVariable String agentRecordId) {
        var buyAgentRecordId = new AgentRecordId(agentRecordId);
        var dueDiligenceProjects = new GetAllProjectsQuery();
        var projects =  projectQueryService.handle(dueDiligenceProjects);
        var agentIncludedProjects = projects.stream()
                .filter(project -> project.getProjectMember().getAllProjectMemberItems().stream()
                        .anyMatch(projectMemberItem -> projectMemberItem.getAgentRecordId().equals(buyAgentRecordId)
                                && projectMemberItem.getAgentRole().agentRole().equals("BUY AGENT")))
                .toList();
        var agentProjectResources = agentIncludedProjects.stream().map(ProjectResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(agentProjectResources);
    }

    @GetMapping("/dashboard")
    public ResponseEntity<DashboardResource> getAgentDashboard(@PathVariable String agentRecordId) {
        var deltaAgentRecordId = new AgentRecordId(agentRecordId);
        var dueDiligenceProjects = new GetAllProjectsQuery();
        var projects =  projectQueryService.handle(dueDiligenceProjects);
        var agentIncludedProjects = projects.stream()
                .filter(project -> project.getProjectMember().getAllProjectMemberItems().stream()
                        .anyMatch(projectMemberItem -> projectMemberItem.getAgentRecordId().equals(deltaAgentRecordId)))
                .toList();
        var totalProjects = agentIncludedProjects.size();
        var completedProjects = agentIncludedProjects.stream()
                .filter(Project::getCompleted)
                .toList().size();
        var activeProjects = totalProjects - completedProjects;
        var totalAgents = agentIncludedProjects.stream()
                .map(project -> project.getProjectMember().getAllProjectMemberItems().stream()
                        .filter(projectMemberItem -> projectMemberItem.getAgentRole().agentRole().equals("SELL AGENT")
                                || projectMemberItem.getAgentRole().agentRole().equals("BUY AGENT"))
                        .toList().size())
                .reduce(0, Integer::sum);
        var dashboardResource = new DashboardResource(totalProjects, activeProjects, completedProjects, totalAgents);
        return ResponseEntity.ok(dashboardResource);
    }
}
