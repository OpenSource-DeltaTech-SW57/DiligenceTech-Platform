package com.deltatech.diligencetech.platform.shared.domain.model.aggregates;

import com.deltatech.diligencetech.platform.shared.domain.model.commands.CreateNotificationCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.aspectj.weaver.ast.Not;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Notification extends AbstractAggregateRoot<Notification> {

  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @Column(nullable = false)
  private String username;

  @Getter
  @Column(nullable = false)
  private String type;

  @Getter
  @Column(nullable = false)
  private String content;

  @Getter
  @Column(nullable = false)
  private String createdAt;


  public Notification(){
  }


  public Notification(String username, String type, String content, Date createdAt){
    this.username = username;
    this.type = type;
    this.content = content;
    this.createdAt = String.valueOf(createdAt);

  }

  public Notification(CreateNotificationCommand command){
    this.type = command.username();
    this.type = command.type();
    this.content = command.content();
    this.createdAt = command.createdAt();
  }

}
