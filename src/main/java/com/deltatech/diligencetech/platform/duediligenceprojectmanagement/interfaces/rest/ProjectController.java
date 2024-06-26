package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.DeleteProjectCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectByIdQuery;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectCommandService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectQueryService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.CreateProjectResource;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.ProjectResource;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.resources.UpdateProjectResource;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.rest.transform.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api/v1/due-diligence-projects", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Due Diligence Projects", description = "Due Diligence Project Management Endpoints")
public class ProjectController {
    private final ProjectCommandService projectCommandService;
    private final ProjectQueryService projectQueryService;

    public ProjectController(ProjectCommandService projectCommandService, ProjectQueryService projectQueryService) {
        this.projectCommandService = projectCommandService;
        this.projectQueryService = projectQueryService;
    }

    @PostMapping
    public ResponseEntity<ProjectResource> createDueDiligenceProject(@RequestBody CreateProjectResource createProjectResource) {
        var createDueDiligenceProjectCommand = CreateProjectCommandFromResourceAssembler.toCommandFromResource(createProjectResource);
        var projectId = projectCommandService.handle(createDueDiligenceProjectCommand);
        if(projectId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getDueDiligenceProjectByIdQuery = new GetProjectByIdQuery(projectId);
        var dueDiligenceProject = projectQueryService.handle(getDueDiligenceProjectByIdQuery);
        if (dueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = ProjectResourceFromEntityAssembler.toResourceFromEntity(dueDiligenceProject.get());
        return new ResponseEntity<>(dueDiligenceProjectResource, HttpStatus.CREATED);
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectResource> getDueDiligenceProjectById(@PathVariable Long projectId) {
        var getDueDiligenceProjectByIdQuery = new GetProjectByIdQuery(projectId);
        var dueDiligenceProject = projectQueryService.handle(getDueDiligenceProjectByIdQuery);
        if (dueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = ProjectResourceFromEntityAssembler.toResourceFromEntity(dueDiligenceProject.get());
        return ResponseEntity.ok(dueDiligenceProjectResource);
    }

    @GetMapping
    public ResponseEntity<List<ProjectResource>> getAllDueDiligenceProjects() {
        var getAllDueDiligenceProjectsQuery = new GetAllProjectsQuery();
        var dueDiligenceProjects = projectQueryService.handle(getAllDueDiligenceProjectsQuery);
        var dueDiligenceProjectResources = dueDiligenceProjects.stream().map(ProjectResourceFromEntityAssembler::toResourceFromEntity).toList();
        return ResponseEntity.ok(dueDiligenceProjectResources);
    }

    @PutMapping("/project-name/{projectId}")
    public ResponseEntity<ProjectResource> updateDueDiligenceProjectName(@PathVariable Long projectId, @RequestBody UpdateProjectResource updateProjectResource) {
        var updateDueDiligenceProjectCommand = UpdateProjectNameCommandFromResourceAssembler.toCommandFromResource(projectId, updateProjectResource);
        var updatedDueDiligenceProject = projectCommandService.handle(updateDueDiligenceProjectCommand);
        if(updatedDueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = ProjectResourceFromEntityAssembler.toResourceFromEntity(updatedDueDiligenceProject.get());
        return ResponseEntity.ok(dueDiligenceProjectResource);
    }

    @PutMapping("/project-buystatus/{projectId}")
    public ResponseEntity<ProjectResource> updateDueDiligenceProjectBuyStatus(@PathVariable Long projectId, @RequestBody String buyStatus) {
        var updateDueDiligenceProjectCommand = UpdateProjectBuyStatusCommandFromResourceAssembler.toCommandFromResource(projectId, buyStatus);
        var updatedDueDiligenceProject = projectCommandService.handle(updateDueDiligenceProjectCommand);
        if(updatedDueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = ProjectResourceFromEntityAssembler.toResourceFromEntity(updatedDueDiligenceProject.get());
        return ResponseEntity.ok(dueDiligenceProjectResource);
    }

    @PutMapping("/project-completed/{projectId}")
    public ResponseEntity<ProjectResource> updateDueDiligenceProjectCompleted(@PathVariable Long projectId, @RequestBody Boolean completed) {
        var updateDueDiligenceProjectCommand = UpdateProjectCompletedCommandFromResourceAssembler.toCommandFromResource(projectId, completed);
        var updatedDueDiligenceProject = projectCommandService.handle(updateDueDiligenceProjectCommand);
        if(updatedDueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = ProjectResourceFromEntityAssembler.toResourceFromEntity(updatedDueDiligenceProject.get());
        return ResponseEntity.ok(dueDiligenceProjectResource);
    }

    @PutMapping("/project-confirm/{projectId}")
    public ResponseEntity<ProjectResource> updateDueDiligenceProjectConfirm(@PathVariable Long projectId, @RequestBody Boolean confirm) {
        var updateDueDiligenceProjectCommand = UpdateProjectConfirmCommandFromResourceAssembler.toCommandFromResource(projectId, confirm);
        var updatedDueDiligenceProject = projectCommandService.handle(updateDueDiligenceProjectCommand);
        if(updatedDueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = ProjectResourceFromEntityAssembler.toResourceFromEntity(updatedDueDiligenceProject.get());
        return ResponseEntity.ok(dueDiligenceProjectResource);
    }

    @PutMapping("/project-sellstatus/{projectId}")
    public ResponseEntity<ProjectResource> updateDueDiligenceProjectSellStatus(@PathVariable Long projectId, @RequestBody String sellStatus) {
        var updateDueDiligenceProjectCommand = UpdateProjectSellStatusCommandFromResourceAssembler.toCommandFromResource(projectId, sellStatus);
        var updatedDueDiligenceProject = projectCommandService.handle(updateDueDiligenceProjectCommand);
        if(updatedDueDiligenceProject.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var dueDiligenceProjectResource = ProjectResourceFromEntityAssembler.toResourceFromEntity(updatedDueDiligenceProject.get());
        return ResponseEntity.ok(dueDiligenceProjectResource);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteDueDiligenceProject(@PathVariable Long projectId) {
        var deleteDueDiligenceProjectCommand = new DeleteProjectCommand(projectId);
        projectCommandService.handle(deleteDueDiligenceProjectCommand);
        return ResponseEntity.ok("Due diligence project with given id successfully deleted");
    }
}