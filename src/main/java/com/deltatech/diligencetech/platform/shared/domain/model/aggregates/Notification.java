package com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates;

import com.deltatech.diligencetech.platform.duediligence.domain.model.commands.CreateNotificationCommand;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Notification {

  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Getter
  @Column(nullable = false)
  private String type;

  @Getter
  @Column(nullable = false)
  private String content;

  @Getter
  @Column(nullable = false)
  private Date createdAt;


  public Notification(){
  }


  public Notification( String type, String content, Date createdAt){
    this.type = type;
    this.content = content;
    this.createdAt = createdAt;
  }

  public Notification(CreateNotificationCommand command){
    this.type = command.type();
    this.content = command.content();
    this.createdAt = command.createdAt();
  }

}
