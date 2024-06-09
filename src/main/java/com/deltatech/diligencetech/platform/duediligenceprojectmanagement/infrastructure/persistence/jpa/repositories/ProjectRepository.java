package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}