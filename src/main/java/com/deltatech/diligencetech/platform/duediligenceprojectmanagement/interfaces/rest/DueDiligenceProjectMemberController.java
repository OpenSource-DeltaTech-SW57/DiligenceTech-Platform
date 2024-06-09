package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.AddMemberToProjectMemberCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectMemberItemByProjectId;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectMemberItemByProjectIdAndAgentId;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.valueobjects.AgentRecordId;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services.DueDiligenceProjectCommandService;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services.DueDiligenceProjectQueryService;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.ProjectMemberItemResource;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform.ProjectMemberItemResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/due-diligence-projects/{projectId}/project-member-items", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Due Diligence Projects")
public class DueDiligenceProjectMemberController {
    private final DueDiligenceProjectCommandService dueDiligenceProjectCommandService;
    private final DueDiligenceProjectQueryService dueDiligenceProjectQueryService;

    public DueDiligenceProjectMemberController(DueDiligenceProjectCommandService dueDiligenceProjectCommandService, DueDiligenceProjectQueryService dueDiligenceProjectQueryService) {
        this.dueDiligenceProjectCommandService = dueDiligenceProjectCommandService;
        this.dueDiligenceProjectQueryService = dueDiligenceProjectQueryService;
    }

    @PostMapping("/{agentRecordId}")
    public ResponseEntity<ProjectMemberItemResource> addMemberToDueDiligenceProjectProjectMember(@PathVariable Long projectId, @PathVariable String agentRecordId) {
        dueDiligenceProjectCommandService.handle(new AddMemberToProjectMemberCommand(new AgentRecordId(agentRecordId), projectId));
        var getProjectMemberItemByDueDiligenceProjectIdAndAgentIdQuery = new GetProjectMemberItemByProjectIdAndAgentId(projectId, new AgentRecordId(agentRecordId));
        var projectMemberItem = dueDiligenceProjectQueryService.handle(getProjectMemberItemByDueDiligenceProjectIdAndAgentIdQuery);
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
        var projectMembers = dueDiligenceProjectQueryService.handle(getAllProjectMembersQuery);
        var projectMemberResources = projectMembers.stream().map(ProjectMemberItemResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(projectMemberResources);
    }

}