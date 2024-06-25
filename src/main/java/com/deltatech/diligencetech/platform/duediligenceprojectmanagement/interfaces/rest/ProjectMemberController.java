package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.AddMemberToProjectMemberCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectMemberItemByProjectId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectMemberItemByProjectIdAndAgentId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentEmail;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRole;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectCommandService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectQueryService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.CreateProjectMemberItemResource;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.ProjectMemberItemResource;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform.ProjectMemberItemResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/due-diligence-projects/{projectId}/project-member-items", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Due Diligence Projects")
public class ProjectMemberController {
    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    public ProjectMemberController(ProjectCommandService projectCommandService, ProjectQueryService projectQueryService) {
        this.projectCommandService = projectCommandService;
        this.projectQueryService = projectQueryService;
    }

    @PostMapping("/{agentRecordId}")
    public ResponseEntity<ProjectMemberItemResource> addMemberToDueDiligenceProjectProjectMember(@PathVariable Long projectId, String agentCode,@RequestBody CreateProjectMemberItemResource command) {
        projectCommandService.handle(new AddMemberToProjectMemberCommand(new AgentRecordId(agentCode), projectId, new AgentRole(command.agentRole())));
        var getProjectMemberItemByDueDiligenceProjectIdAndAgentIdQuery = new GetProjectMemberItemByProjectIdAndAgentId(projectId, new AgentRecordId(agentCode));
        var projectMemberItem = projectQueryService.handle(getProjectMemberItemByDueDiligenceProjectIdAndAgentIdQuery);
        if (projectMemberItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            var projectMemberItemResource = ProjectMemberItemResourceFromEntityAssembler.toResourceFromEntity(projectMemberItem.get());
            return ResponseEntity.ok(projectMemberItemResource);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProjectMemberItemResource>> getAllProjectMembers(@PathVariable Long projectId) {
        var getAllProjectMembersQuery = new GetAllProjectMemberItemByProjectId(projectId);
        var projectMembers = projectQueryService.handle(getAllProjectMembersQuery);
        var projectMemberResources = projectMembers.stream().map(ProjectMemberItemResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(projectMemberResources);
    }

    @GetMapping("/sell-agents")
    public ResponseEntity<List<ProjectMemberItemResource>> getAllProjectMembersSellAgents(@PathVariable Long projectId) {
        var getAllProjectMembersQuery = new GetAllProjectMemberItemByProjectId(projectId);
        var projectMembers = projectQueryService.handle(getAllProjectMembersQuery);
        var projectMemberResources = projectMembers.stream().map(ProjectMemberItemResourceFromEntityAssembler::toResourceFromEntity).toList();
        var memberSellAgents = projectMemberResources.stream().filter(projectMemberItemResource -> projectMemberItemResource.agentRole().equals("SELL AGENT")).toList();
        return ResponseEntity.ok(memberSellAgents);
    }

    @GetMapping("/buy-agents")
    public ResponseEntity<List<ProjectMemberItemResource>> getAllProjectMembersBuyAgents(@PathVariable Long projectId) {
        var getAllProjectMembersQuery = new GetAllProjectMemberItemByProjectId(projectId);
        var projectMembers = projectQueryService.handle(getAllProjectMembersQuery);
        var projectMemberResources = projectMembers.stream().map(ProjectMemberItemResourceFromEntityAssembler::toResourceFromEntity).toList();
        var memberBuyAgents = projectMemberResources.stream().filter(projectMemberItemResource -> projectMemberItemResource.agentRole().equals("BUY AGENT")).toList();
        return ResponseEntity.ok(memberBuyAgents);
    }
}