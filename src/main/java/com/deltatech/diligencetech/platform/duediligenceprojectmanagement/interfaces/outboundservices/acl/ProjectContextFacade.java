package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.outboundservices.acl;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.commands.CreateProjectCommand;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectByIdQuery;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectCommandService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectQueryService;
import org.springframework.stereotype.Service;

@Service

public class ProjectContextFacade {
  private final ProjectCommandService projectCommandService;
  private final ProjectQueryService projectQueryService;

  public ProjectContextFacade(ProjectCommandService projectCommandService, ProjectQueryService projectQueryService) {
    this.projectCommandService = projectCommandService;
    this.projectQueryService = projectQueryService;
  }

  //old
  //public Long createProject(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
  //  var createProjectCommand = new CreateProjectCommand(projectFullName, managerFirstName, managerLastName, startDate, endDate, budget, progress, status);
  //  var projectId = projectCommandService.handle(createProjectCommand);
  //  var getProjectByIdQuery = new GetProjectByIdQuery(projectId);
  //  var project = projectQueryService.handle(getProjectByIdQuery);
  //  if (project.isEmpty()) return 0L;
  //  return project.get().getId();
  //}
  //new
  public Long createProject(String projectFullName) {
    var createProjectCommand = new CreateProjectCommand(projectFullName);
    var projectId = projectCommandService.handle(createProjectCommand);
    var getProjectByIdQuery = new GetProjectByIdQuery(projectId);
    var project = projectQueryService.handle(getProjectByIdQuery);
    if (project.isEmpty()) return 0L;
    return project.get().getId();
  }

  /**
   * Fetches the project id by code
   *
   * @param projectId the code
   * @return the agent id
   */
  public Long fetchProjectIdById(Long projectId) {
    var getProjectByIdQuery = new GetProjectByIdQuery(projectId);
    var project = projectQueryService.handle(getProjectByIdQuery);
    if (project.isEmpty()) return 0L;
    return project.get().getId();
  }
}