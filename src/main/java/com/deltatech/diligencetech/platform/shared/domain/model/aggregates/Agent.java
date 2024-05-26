package com.deltatech.diligencetech.platform.shared.domain.model.aggregates;
import com.deltatech.diligencetech.platform.shared.domain.model.commands.CreateAgentCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Agent extends AbstractAggregateRoot<Agent> {

  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @Column(nullable = false)
  private String agentId;

  @Getter
  @Column (nullable = false)
  private String username;

  @Getter
  @Column (nullable = false)
  private String password;

  @Getter
  @Column (nullable = false)
  private String email;


  public Agent() {
  }


  protected Agent( String agentId, String username, String password, String email){
    this.agentId = agentId;
    this.username = username;
    this.password = password;
    this.email = email;
  }

  public Agent(CreateAgentCommand command){
    this.agentId = command.agentId();
    this.username = command.username();
    this.password = command.password();
    this.email = command.email();
  }
}
