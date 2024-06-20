package com.deltatech.diligencetech.platform.duediligencefilemanagement.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligenceagents.domain.model.aggregates.Agent;
import com.deltatech.diligencetech.platform.duediligencefilemanagement.domain.model.aggregates.Area;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AreaRepository extends JpaRepository<Area, Long> {
  Optional<Area> findByCode(Long code);
  boolean existsByCode(Long areaId);
}
