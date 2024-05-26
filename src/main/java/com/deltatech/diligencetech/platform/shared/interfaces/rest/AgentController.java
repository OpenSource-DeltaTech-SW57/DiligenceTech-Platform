package com.deltatech.diligencetech.platform.shared.interfaces.rest;

import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetAgentByIdQuery;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetAllAgentsQuery;
import com.deltatech.diligencetech.platform.shared.domain.services.AgentCommandService;
import com.deltatech.diligencetech.platform.shared.domain.services.AgentQueryService;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.resources.AgentResource;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.transform.AgentResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.transform.CreateAgentCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.transform.CreateAgentResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/agents")
public class AgentController {
  private final AgentQueryService agentQueryService;
  private final AgentCommandService agentCommandService;
  public AgentController(AgentQueryService agentQueryService, AgentCommandService agentCommandService) {
    this.agentQueryService = agentQueryService;
    this.agentCommandService = agentCommandService;
  }

  @PostMapping
  public ResponseEntity<AgentResource> createAgent(@RequestBody CreateAgentResource resource) {
    Optional<Agent> agent = agentCommandService.handle(CreateAgentCommandFromResourceAssembler.toCommandFromResource(resource));
    return agent.map(source->new ResponseEntity<>(AgentResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).orElseGet(()->ResponseEntity.badRequest().build());
  }

  @GetMapping
  public ResponseEntity<List<AgentResource>> getAllAgents() {
    var getAllAgentsQuery = new GetAllAgentsQuery();
    var agents = agentQueryService.handle(getAllAgentsQuery);
    var agentResources = agents.stream().map(AgentResourceFromEntityAssembler::toResourceFromEntity).toList();
    return ResponseEntity.ok(agentResources);
  }

  @GetMapping("/{id}")
    public ResponseEntity<AgentResource> getAgentById(@PathVariable Long id) {
        var getAgentByIdQuery = new GetAgentByIdQuery(id);
        var agent = agentQueryService.handle(getAgentByIdQuery);
        if(agent.isEmpty())
            return ResponseEntity.notFound().build();
        var agentResource = AgentResourceFromEntityAssembler.toResourceFromEntity(agent.get());
        return ResponseEntity.ok(agentResource);
    }
}
