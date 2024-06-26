package com.deltatech.diligencetech.platform.profiles.interfaces.rest;

import com.deltatech.diligencetech.platform.profiles.domain.model.commands.DeleteAgentCommand;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByEmailQuery;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByIdQuery;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAgentByUsernameQuery;
import com.deltatech.diligencetech.platform.profiles.domain.model.queries.GetAllAgentsQuery;
import com.deltatech.diligencetech.platform.profiles.domain.services.AgentCommandService;
import com.deltatech.diligencetech.platform.profiles.domain.services.AgentQueryService;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.AgentResource;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.CreateAgentResource;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.UpdateAgentBiographyAndProfilePicResource;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.resources.UpdateAgentUsernameResource;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform.AgentResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform.CreateAgentCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform.UpdateAgentBiographyAndPicCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.profiles.interfaces.rest.transform.UpdateAgentUsernameCommandFromResourceAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "/api/v1/agents", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Agents", description = "Agents Management Endpoints")
public class AgentController
{
  private final AgentCommandService agentCommandService;
  private final AgentQueryService agentQueryService;

  public AgentController(AgentCommandService agentCommandService, AgentQueryService agentQueryService) {
    this.agentCommandService = agentCommandService;
    this.agentQueryService = agentQueryService;
  }


  /**
   * Creates a new course.
   * @param createAgentResource the resource containing the data for the course to be created
   * @return the created course resource
   * @see CreateAgentResource
   * @see AgentResource
   */
  @PostMapping
  public ResponseEntity<AgentResource> createAgent(@RequestBody CreateAgentResource createAgentResource) {
    var createCourseCommand = CreateAgentCommandFromResourceAssembler.toCommandFromResource(createAgentResource);
    var agentId = agentCommandService.handle(createCourseCommand);
    if (agentId == 0L) {
      return ResponseEntity.badRequest().build();
    }
    var getAgentByIdQuery = new GetAgentByIdQuery(agentId);
    var agent = agentQueryService.handle(getAgentByIdQuery);
    if (agent.isEmpty()) return ResponseEntity.badRequest().build();
    var agentResource = AgentResourceFromEntityAssembler.toResourceFromEntity(agent.get());
    return new ResponseEntity<>(agentResource, HttpStatus.CREATED);
  }

  /**
   * Gets an agent by its id.
   *
   * @param agentId the id of the course to be retrieved
   * @return the course resource with the given id
   * @see AgentResource
   */
  @GetMapping("/{agentId}")
  public ResponseEntity<AgentResource> getAgentById(@PathVariable Long agentId) {
    var getAgentByIdQuery = new GetAgentByIdQuery(agentId);
    var agent = agentQueryService.handle(getAgentByIdQuery);
    if (agent.isEmpty()) return ResponseEntity.badRequest().build();
    var agentResource = AgentResourceFromEntityAssembler.toResourceFromEntity(agent.get());
    return ResponseEntity.ok(agentResource);
  }


  @GetMapping("/email/{agentEmail}")
  public ResponseEntity<AgentResource> getAgentByEmail(@PathVariable String agentEmail) {
    var getAgentByIdQuery = new GetAgentByEmailQuery(agentEmail);
    var agent = agentQueryService.handle(getAgentByIdQuery);
    if (agent.isEmpty()) return ResponseEntity.badRequest().build();
    var agentResource = AgentResourceFromEntityAssembler.toResourceFromEntity(agent.get());
    return ResponseEntity.ok(agentResource);
  }

  @GetMapping("/username/{username}")
  public ResponseEntity<AgentResource> getAgentUsername(@PathVariable String username) {
    var getAgentByIdQuery = new GetAgentByUsernameQuery(username);
    var agent = agentQueryService.handle(getAgentByIdQuery);
    if (agent.isEmpty()) return ResponseEntity.badRequest().build();
    var agentResource = AgentResourceFromEntityAssembler.toResourceFromEntity(agent.get());
    return ResponseEntity.ok(agentResource);
  }

  /*
   * Gets an agent by its code.
   *
   * @param agentCode the id of the course to be retrieved
   * @return the course resource with the given code
   * @see AgentResource
   *
   * @GetMapping("/{agentCode}")
  public ResponseEntity<AgentResource> getAgentByCode(@PathVariable String agentCode) {
    var getAgentByCodeQuery = new GetAgentByCodeQuery(agentCode);
    var agent = agentQueryService.handle(getAgentByCodeQuery);
    if (agent.isEmpty()) return ResponseEntity.badRequest().build();
    var agentResource = AgentResourceFromEntityAssembler.toResourceFromEntity(agent.get());
    return ResponseEntity.ok(agentResource);
  }
   */

  /**
   * Gets all the courses.
   *
   * @return the list of all the course resources
   * @see AgentResource
   */
  @GetMapping
  public ResponseEntity<List<AgentResource>> getAllAgents() {
    var getAllAgentsQuery = new GetAllAgentsQuery();
    var agents = agentQueryService.handle(getAllAgentsQuery);
    var agentResources = agents.stream().map(AgentResourceFromEntityAssembler::toResourceFromEntity).toList();
    return ResponseEntity.ok(agentResources);
  }

  /**
   * Updates a course.
   *
   * @param agentId             the id of the course to be updated
   * @param updateAgentResource the resource containing the data for the course to be updated
   * @return the updated course resource
   * @see UpdateAgentUsernameResource
   * @see AgentResource
   */
  @PutMapping("/{agentId}")
  public ResponseEntity<AgentResource> updateAgent(@PathVariable Long agentId, @RequestBody UpdateAgentUsernameResource updateAgentResource) {
    var updateAgentCommand = UpdateAgentUsernameCommandFromResourceAssembler.toCommandFromResource(agentId, updateAgentResource.username());
    var updatedAgent = agentCommandService.handle(updateAgentCommand);
    if (updatedAgent.isEmpty()) {
      return ResponseEntity.badRequest().build();
    }
    var agentResource = AgentResourceFromEntityAssembler.toResourceFromEntity(updatedAgent.get());
    return ResponseEntity.ok(agentResource);
  }

  /**
   * Deletes a course.
   *
   * @param agentId
   * @return Deletion confirmation message
   */
  @DeleteMapping("/{AgentId}")
  public ResponseEntity<?> deleteAgent(@PathVariable Long agentId) {
    var deleteAgentCommand = new DeleteAgentCommand(agentId);
    agentCommandService.handle(deleteAgentCommand);
    return ResponseEntity.ok("Course with given id successfully deleted");
  }
}
