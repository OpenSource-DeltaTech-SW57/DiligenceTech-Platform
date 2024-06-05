package com.deltatech.diligencetech.platform.communications.domain.model.entity;

import com.deltatech.diligencetech.platform.communications.domain.model.valueobjects.NotificationData;
import com.deltatech.diligencetech.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;


@Entity
public class Notification extends AuditableModel {

  @Id
  @Getter
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;


  @Embedded
  @Getter
  private NotificationData notificationData;

  public Notification() { }


}
