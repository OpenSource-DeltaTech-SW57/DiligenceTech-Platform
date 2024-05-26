package com.deltatech.diligencetech.platform.duediligence.infrastructure.persistence.jpa.repositories;


import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
  Optional<Agent> findByAgentId(String agentId);
  boolean existByAgentId(String agentId);
}
