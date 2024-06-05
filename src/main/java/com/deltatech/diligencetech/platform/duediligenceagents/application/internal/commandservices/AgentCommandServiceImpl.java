package com.deltatech.diligencetech.platform.duediligenceagents.application.internal.commandservices;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.DeleteAgentCommand;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.UpdateAgentCommand;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.services.AgentCommandService;
import com.deltatech.diligencetech.platform.duediligenceagents.infrastructure.persistence.jpa.repositories.AgentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgentCommandServiceImpl implements AgentCommandService {

  private final AgentRepository agentRepository;

  public AgentCommandServiceImpl(AgentRepository agentRepository) {
    this.agentRepository = agentRepository;
  }

  @Override
  public Long handle(CreateAgentCommand command) {
    if (agentRepository.existsByCode(command.code())){
      throw new IllegalArgumentException("Agent with same code already exists");
    }
    var agent = new Agent(command);
    try {
      agentRepository.save(agent);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while saving agent: " + e.getMessage());
    }
    return agent.getId();
  }

  @Override
  public Optional<Agent> handle(UpdateAgentCommand command) {
    if (agentRepository.existsByCode(command.username(), command.id()))
      throw new IllegalArgumentException("Course with same title already exists");
    var result = courseRepository.findById(command.id());
    if (result.isEmpty()) throw new IllegalArgumentException("Course does not exist");
    var courseToUpdate = result.get();
    try {
      var updatedCourse = courseRepository.save(courseToUpdate.updateInformation(command.title(), command.description()));
      return Optional.of(updatedCourse);
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while updating course: " + e.getMessage());
    }
  }

  @Override
  public void handle(DeleteAgentCommand command) {
    if (!agentRepository.existsById(command.agentId())) {
      throw new IllegalArgumentException("Agent does not exist");
    }
    try {
      agentRepository.deleteById(command.agentId());
    } catch (Exception e) {
      throw new IllegalArgumentException("Error while deleting agent: " + e.getMessage());
    }

  }}
