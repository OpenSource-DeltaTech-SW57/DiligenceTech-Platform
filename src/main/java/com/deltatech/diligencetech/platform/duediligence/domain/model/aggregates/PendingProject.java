package com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;

@Entity
public class PendingProject {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private Long id;

      @Column(nullable = false)
      @Getter
      private boolean obligatory;

  @Column(nullable = false)
  @Getter
  private Date datePublished;

  @Column(nullable = false)
  @Getter
  private String name;


}
