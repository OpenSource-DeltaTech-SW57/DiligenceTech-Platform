package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.infrastructure.persistence.jpa.repositories;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.DueDiligenceProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DueDiligenceProjectRepository extends JpaRepository<DueDiligenceProject, Long> {
}
