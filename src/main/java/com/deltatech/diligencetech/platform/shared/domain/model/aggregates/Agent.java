package com.deltatech.diligencetech.platform.duediligence.shared.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.data.domain.AbstractAggregateRoot;

@Entity
public class Agent extends AbstractAggregateRoot<Agent> {
  @Id
  private Long id;
}
