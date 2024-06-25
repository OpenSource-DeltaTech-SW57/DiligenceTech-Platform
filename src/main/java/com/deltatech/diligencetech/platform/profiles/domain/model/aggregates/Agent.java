package com.deltatech.diligencetech.platform.profiles.domain.model.aggregates;

import com.deltatech.diligencetech.platform.profiles.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.profiles.domain.model.valueobjects.AgentName;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
public class Agent extends AuditableAbstractAggregateRoot<Agent> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
    private Long id;

  @Column
  @Getter
  private String imageUrl;


  @Embedded
  private AgentName name;

  @Column
  @Getter
  private String email;

  @Column
  @Getter
  private String location;

  @Column
  @Getter
  private String biography;

  @Column(unique = true)
  @Getter
  private String username;

  public Agent() {
    }

  public Agent(CreateAgentCommand command) {
    this.name = new AgentName(command.firstname(), command.lastName());
    this.imageUrl = command.imageUrl();
    this.email = command.email();
    this.biography = command.biography();
    this.username = command.username();
    this.location = command.location();
    }

  public Agent updateUsername(String username) {
    this.username = username;
   return this;
  }

  public String getFullName() {
    return name.getFullName();
  }
}