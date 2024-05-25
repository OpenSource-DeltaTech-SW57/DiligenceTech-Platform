package com.deltatech.diligencetech.platform.duediligence.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.PendingProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PendingProjectRepository extends JpaRepository<PendingProject, Long> {
  Optional<PendingProject> findByName(String name);
}
