package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.AddMemberToProjectMemberCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectMemberItemByProjectId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectMemberItemByProjectIdAndAgentId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectCommandService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectQueryService;
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
    public ResponseEntity<ProjectMemberItemResource> addMemberToDueDiligenceProjectProjectMember(@PathVariable Long projectId, @PathVariable String agentRecordId) {
        projectCommandService.handle(new AddMemberToProjectMemberCommand(new AgentRecordId(agentRecordId), projectId));
        var getProjectMemberItemByDueDiligenceProjectIdAndAgentIdQuery = new GetProjectMemberItemByProjectIdAndAgentId(projectId, new AgentRecordId(agentRecordId));
        var projectMemberItem = projectQueryService.handle(getProjectMemberItemByDueDiligenceProjectIdAndAgentIdQuery);
        if (projectMemberItem.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            var projectMemberItemResource = ProjectMemberItemResourceFromEntityAssembler.toResourceFromEntity(projectMemberItem.get());
            return ResponseEntity.ok(projectMemberItemResource);
        }
    }

    @GetMapping
    public ResponseEntity<List<ProjectMemberItemResource>> getAllProjectMembers(@PathVariable Long projectId) {
        var getAllProjectMembersQuery = new GetAllProjectMemberItemByProjectId(projectId);
        var projectMembers = projectQueryService.handle(getAllProjectMembersQuery);
        var projectMemberResources = projectMembers.stream().map(ProjectMemberItemResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(projectMemberResources);
    }

}