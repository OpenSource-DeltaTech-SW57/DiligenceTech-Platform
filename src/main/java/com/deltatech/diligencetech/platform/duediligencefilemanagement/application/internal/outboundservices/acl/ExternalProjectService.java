package com.deltatech.diligencetech.platform.duediligencefilemanagement.application.internal.outboundservices.acl;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.interfaces.outboundservices.acl.ProjectContextFacade;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ExternalProjectService {

  private final ProjectContextFacade projectContextFacade;

  public ExternalProjectService(ProjectContextFacade projectContextFacade) {
    this.projectContextFacade = projectContextFacade;
  }


  /**
   * Fetch agentId by email
   *
   * @param projectId the id to search for
   * @return projectId if found, empty otherwise
   */
  public Optional<Long>  fetchProjectIdById(Long projectId) {
    var testId = projectContextFacade.fetchProjectIdById(projectId);
    if (testId == 0L) return Optional.empty();
    return Optional.of(testId);
  }

    /**
     * Create a project
     *
     * @param projectFullName the project full name
     * @param managerFirstName the manager first name
     * @param managerLastName the manager last name
     * @param startDate the start date
     * @param endDate the end date
     * @param budget the budget
     * @param progress the progress
     * @param status the status
     * @return projectId if created, empty otherwise
     */

  public Optional<Long> createProject(String projectFullName, String managerFirstName, String managerLastName, String startDate, String endDate, Float budget, Long progress, String status) {
    var testId = projectContextFacade.createProject(projectFullName, managerFirstName, managerLastName, startDate, endDate, budget, progress, status);
    if (testId == 0L) return Optional.empty();
    return Optional.of(testId);
  }
}
