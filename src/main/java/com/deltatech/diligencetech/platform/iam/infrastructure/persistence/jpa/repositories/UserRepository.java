package com.deltatech.diligencetech.platform.iam.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.iam.domain.model.aggregates.User;
import com.deltatech.diligencetech.platform.iam.domain.model.valueobjects.AgentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByAgentId(AgentId agentId);
    boolean existsByEmail(String email);
}
