package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.DueDiligenceProject;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.DeleteDueDiligenceProjectCommand;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectByIdQuery;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services.DueDiligenceProjectCommandService;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services.DueDiligenceProjectQueryService;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.CreateDueDiligenceProjectResource;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.DueDiligenceProjectResource;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateDueDiligenceProjectResource;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform.CreateDueDiligenceProjectCommandFromResourceAssembler;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform.DueDiligenceProjectResourceFromEntityAssembler;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform.UpdateDueDiligenceProjectCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/due-diligence-projects", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Due Diligence Projects", description = "Due Diligence Project Management Endpoints")
public class DueDiligenceProjectController {
    private final DueDiligenceProjectCommandService dueDiligenceProjectCommandService;
    private final DueDiligenceProjectQueryService dueDiligenceProjectQueryService;

    public DueDiligenceProjectController(DueDiligenceProjectCommandService dueDiligenceProjectCommandService, DueDiligenceProjectQueryService dueDiligenceProjectQueryService) {
        this.dueDiligenceProjectCommandService = dueDiligenceProjectCommandService;
        this.dueDiligenceProjectQueryService = dueDiligenceProjectQueryService;
    }

    @PostMapping
    public ResponseEntity<DueDiligenceProjectResource> createDueDiligenceProject(@RequestBody CreateDueDiligenceProjectResource createDueDiligenceProjectResource) {
        var createDueDiligenceProjectCommand = CreateDueDiligenceProjectCommandFromResourceAssembler.toCommandFromResource(createDueDiligenceProjectResource);
        var projectId = dueDiligenceProjectCommandService.handle(createDueDiligenceProjectCommand);
        if(projectId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getDueDiligenceProjectByIdQuery = new GetProjectByIdQuery(projectId);
        var dueDiligenceProject = dueDiligenceProjectQueryService.handle(getDueDiligenceProjectByIdQuery);
        if (dueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = DueDiligenceProjectResourceFromEntityAssembler.toResourceFromEntity(dueDiligenceProject.get());
        return new ResponseEntity<>(dueDiligenceProjectResource, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<DueDiligenceProjectResource> getDueDiligenceProjectById(@PathVariable Long projectId) {
        var getDueDiligenceProjectByIdQuery = new GetProjectByIdQuery(projectId);
        var dueDiligenceProject = dueDiligenceProjectQueryService.handle(getDueDiligenceProjectByIdQuery);
        if (dueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = DueDiligenceProjectResourceFromEntityAssembler.toResourceFromEntity(dueDiligenceProject.get());
        return ResponseEntity.ok(dueDiligenceProjectResource);
    }

    @GetMapping
    public ResponseEntity<List<DueDiligenceProjectResource>> getAllDueDiligenceProjects() {
        var getAllDueDiligenceProjectsQuery = new GetAllProjectsQuery();
        var dueDiligenceProjects = dueDiligenceProjectQueryService.handle(getAllDueDiligenceProjectsQuery);
        var dueDiligenceProjectResources = dueDiligenceProjects.stream().map(DueDiligenceProjectResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(dueDiligenceProjectResources);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity<DueDiligenceProjectResource> updateDueDiligenceProject(@PathVariable Long projectId, @RequestBody UpdateDueDiligenceProjectResource updateDueDiligenceProjectResource) {
        var updateDueDiligenceProjectCommand = UpdateDueDiligenceProjectCommandFromResourceAssembler.toCommandFromResource(projectId, updateDueDiligenceProjectResource);
        var updatedDueDiligenceProject = dueDiligenceProjectCommandService.handle(updateDueDiligenceProjectCommand);
        if(updatedDueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = DueDiligenceProjectResourceFromEntityAssembler.toResourceFromEntity(updatedDueDiligenceProject.get());
        return ResponseEntity.ok(dueDiligenceProjectResource);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteDueDiligenceProject(@PathVariable Long projectId) {
        var deleteDueDiligenceProjectCommand = new DeleteDueDiligenceProjectCommand(projectId);
        dueDiligenceProjectCommandService.handle(deleteDueDiligenceProjectCommand);
        return ResponseEntity.ok("Due diligence project with given id successfully deleted");
    }
}
