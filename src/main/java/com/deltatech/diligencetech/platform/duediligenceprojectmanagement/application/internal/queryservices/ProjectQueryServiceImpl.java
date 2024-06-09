package com.deltatech.diligencetech.platform.duediligenceprojectmanagement.application.internal.queryservices;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities.ProjectMemberItem;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectMemberItemByProjectId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectByIdQuery;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectMemberItemByProjectIdAndAgentId;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.services.ProjectQueryService;
import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.infrastructure.persistence.jpa.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectQueryServiceImpl implements ProjectQueryService {
    private final ProjectRepository projectRepository;

    public ProjectQueryServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Optional<Project> handle(GetProjectByIdQuery query) {
        return projectRepository.findById(query.projectId());
    }

    @Override
    public List<Project> handle(GetAllProjectsQuery query) {
        return projectRepository.findAll();
    }

    @Override
    public List<ProjectMemberItem> handle(GetAllProjectMemberItemByProjectId query) {
        return projectRepository.findById(query.projectId()).map(dueDiligenceProject -> dueDiligenceProject.getProjectMember().getAllProjectMemberItems()).orElse(Collections.emptyList());
    }

    @Override
    public Optional<ProjectMemberItem> handle(GetProjectMemberItemByProjectIdAndAgentId query) {
        return projectRepository.findById(query.projectId()).map(dueDiligenceProject -> dueDiligenceProject.getProjectMember().getProjectMemberItemWithAgentRecordId(query.agentId()));
    }
}