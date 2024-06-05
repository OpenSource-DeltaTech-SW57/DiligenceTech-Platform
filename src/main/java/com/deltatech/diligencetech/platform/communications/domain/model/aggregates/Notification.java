package com.deltatech.diligencetech.platform.communications.domain.model.aggregates;

import com.deltatech.diligencetech.platform.communications.domain.model.valueobjects.NotificationData;
import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.deltatech.diligencetech.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
public class Notification extends AuditableAbstractAggregateRoot<Notification> {

  @Embedded
  @Getter
  private NotificationData notificationData;

  public Notification() { }

}