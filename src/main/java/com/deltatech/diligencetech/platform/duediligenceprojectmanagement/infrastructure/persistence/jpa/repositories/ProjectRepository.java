package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities.ProjectMemberItem;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectMemberItemByProjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<ProjectMemberItem> findMembersById(GetAllProjectMemberItemByProjectId id);
}