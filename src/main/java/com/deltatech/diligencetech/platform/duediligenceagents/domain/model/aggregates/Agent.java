package com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.AgentData;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.AgentRole;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.Image;
import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects.ProfileId;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;

@Getter
@Entity
public class Agent extends AbstractAggregateRoot<Agent> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
    private Long id;

  @Embedded
  private AgentRole agentRole;

  @Embedded
  private Image image;

  @Embedded
  private AgentData agentData;

  @Column(unique = true)
  @Getter
  private String code;

  public Agent() {
   /* this.profileId = new ProfileId();*/
    this.agentRole = new AgentRole();
    this.image = new Image();
    }


  public Agent(CreateAgentCommand command) {
    this.code = command.code();
    this.agentData = new AgentData(command.email(), command.username(), command.password());
    this.image = new Image(command.imageUrl());
    }

  public Agent updateUsername(String username) {
   this.agentData = new AgentData(this.agentData.email(), username, this.agentData.password());
   return this;
  }
}