package com.deltatech.diligencetech.platform.profiles.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectQueryService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.ProjectMemberItemResource;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform.ProjectMemberItemResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.AgentProjectResource;
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


    @GetMapping("/{projectId}/team")
    public ResponseEntity<List<ProjectMemberItemResource>> getAllTeamInAProject(@PathVariable Long projectId) {
        var teamDueDiligenceProjects = new GetAllProjectsQuery();
        var projects = projectQueryService.handle(teamDueDiligenceProjects);
        var project = projects.stream()
                .filter(proj -> proj.getId().equals(projectId))
                .findFirst()
                .orElse(null);

        if (project == null) {
            return ResponseEntity.notFound().build();
        }
        var projectMemberItems = project.getProjectMember().getAllProjectMemberItems();
        var projectMemberItemResources = projectMemberItems.stream()
                .map(ProjectMemberItemResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(projectMemberItemResources);
    }

    @GetMapping("/{projectId}/sell-team")
    public ResponseEntity<List<ProjectMemberItemResource>> getAllSellTeamInAProject(@PathVariable Long projectId) {
        var sellTeamDueDiligenceProjects = new GetAllProjectsQuery();
        var projects = projectQueryService.handle(sellTeamDueDiligenceProjects);
        var project = projects.stream()
                .filter(proj -> proj.getId().equals(projectId))
                .findFirst()
                .orElse(null);

        if (project == null) {
            return ResponseEntity.notFound().build();
        }

        var projectMemberItems = project.getProjectMember().getAllProjectMemberItems();
        var sellAgentMemberItems = projectMemberItems.stream()
                .filter(memberItem -> memberItem.getAgentRole().agentRole().equals("SELL AGENT"))
                .map(ProjectMemberItemResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(sellAgentMemberItems);
    }

    @GetMapping("/{projectId}/buy-team")
    public ResponseEntity<List<ProjectMemberItemResource>> getAllBuyTeamInAProject(@PathVariable Long projectId) {
        var buyTeamDueDiligenceProjects = new GetAllProjectsQuery();
        var projects = projectQueryService.handle(buyTeamDueDiligenceProjects);
        var project = projects.stream()
                .filter(proj -> proj.getId().equals(projectId))
                .findFirst()
                .orElse(null);

        if (project == null) {
            return ResponseEntity.notFound().build();
        }

        var projectMemberItems = project.getProjectMember().getAllProjectMemberItems();
        var buyAgentMemberItems = projectMemberItems.stream()
                .filter(memberItem -> memberItem.getAgentRole().agentRole().equals("BUY AGENT"))
                .map(ProjectMemberItemResourceFromEntityAssembler::toResourceFromEntity)
                .toList();

        return ResponseEntity.ok(buyAgentMemberItems);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectMemberItemResource> getAgentDataInAProject(@PathVariable String agentRecordId,Long projectId) {
        var deltaAgentRecordId = new AgentRecordId(agentRecordId);
        var dueDiligenceProjects = new GetAllProjectsQuery();
        var projects = projectQueryService.handle(dueDiligenceProjects);
        var project = projects.stream()
                .filter(proj -> proj.getId().equals(projectId))
                .findFirst()
                .orElse(null);

        if (project == null) {
            return ResponseEntity.notFound().build();
        }

        var projectMemberItem = project.getProjectMember().getAllProjectMemberItems().stream()
                .filter(memberItem -> memberItem.getAgentRecordId().equals(deltaAgentRecordId))
                .findFirst()
                .orElse(null);
        if (projectMemberItem == null) {
            return ResponseEntity.notFound().build();
        }
        var projectMemberItemResource = ProjectMemberItemResourceFromEntityAssembler.toResourceFromEntity(projectMemberItem);
        //var projectMemberItemResource = ProjectMemberItemResourceFromEntityAssembler.fromEntity(projectMemberItem);
        return ResponseEntity.ok(projectMemberItemResource);
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
        var agentProjectResources = agentIncludedProjects.stream().map(project -> ProjectResourceFromEntityAssembler.toResourceFromEntity(project, agentRecordId)).toList();
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
        var agentProjectResources = agentIncludedProjects.stream().map(project -> ProjectResourceFromEntityAssembler.toResourceFromEntity(project, agentRecordId)).toList();
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
        var agentProjectResources = agentIncludedProjects.stream().map(project -> ProjectResourceFromEntityAssembler.toResourceFromEntity(project, agentRecordId)).toList();
        return ResponseEntity.ok(agentProjectResources);
    }
}
