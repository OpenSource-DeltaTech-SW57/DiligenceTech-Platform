package com.deltatech.diligencetech.platform.profiles.domain.model.aggregates;

import com.deltatech.diligencetech.platform.profiles.domain.model.commands.CreateAgentCommand;
import com.deltatech.diligencetech.platform.profiles.domain.model.valueobjects.AgentRole;
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

  @Column
  @Getter
  private String imageUrl;

  @Column
  @Getter
  private String email;

  @Column
  @Getter
  private String password;

  @Column
  @Getter
  private String username;

  @Column(unique = true)
  @Getter
  private String code;

  public Agent() {
   /* this.profileId = new ProfileId();*/
    this.agentRole = new AgentRole();
    this.imageUrl = "";
    this.email = "";
    this.password = "";
    this.username = "";
    }


  public Agent(CreateAgentCommand command) {
    this.code = command.code();
    this.imageUrl = command.imageUrl();
    this.email = command.email();
    this.password = command.password();
    this.username = command.username();
    }



  public Agent updateUsername(String username) {
    this.username = username;
   return this;
  }
}