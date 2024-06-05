package com.deltatech.diligencetech.platform.duediligenceagents.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, Long> {
  boolean existsByCode(String code);
}
