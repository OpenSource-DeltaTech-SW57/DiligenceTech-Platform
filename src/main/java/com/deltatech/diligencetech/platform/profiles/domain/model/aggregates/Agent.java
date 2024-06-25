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
<<<<<<< HEAD
  private String location;
=======
  private String biography;
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef

  @Column
  @Getter
  private String password;

  @Column(unique = true)
  @Getter
  private String username;



  public Agent() {
<<<<<<< HEAD
=======
    this.code = "";
    this.agentRole = new AgentRole();
    this.imageUrl = "";
    this.email = "";
    this.biography = "";
    this.username = "";
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
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

<<<<<<< HEAD
  public String getFullName() {
    return name.getFullName();
=======
  public Agent updateBiographyAndProfilePic(String biography, String imageUrl) {
    this.biography = biography;
    this.imageUrl = imageUrl;
    return this;
>>>>>>> 50c506ee37cf2ee0e4d7f65bf3b4f566d28ed2ef
  }
}