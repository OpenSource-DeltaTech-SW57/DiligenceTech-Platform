package com.deltatech.diligencetech.platform.communications.domain.model.aggregates;

import com.deltatech.diligencetech.platform.communications.domain.model.commands.CreateNotificationCommand;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
public class Notification extends AuditableAbstractAggregateRoot<Notification> {

  //@Embedded
  //@Getter
  //private NotificationData notificationData;

  @Column
  @Getter
  private Long agentId;


  @Column
  @Getter
  private String type;



  @Column
  @Getter
  private String content;




  public Notification() {
  }




  public Notification(CreateNotificationCommand command) {
    this.agentId = command.agentId();
    this.type = command.type();
    this.content = command.content();
  }

}