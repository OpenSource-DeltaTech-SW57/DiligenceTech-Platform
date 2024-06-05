package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.application.internal.queryservices;

import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.DueDiligenceProject;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities.ProjectMemberItem;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectMemberItemByProjectId;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetAllProjectsQuery;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectByIdQuery;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.queries.GetProjectMemberItemByProjectIdAndAgentId;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.services.DueDiligenceProjectQueryService;
import com.deltetech.diligencetech.platform.duediligenceprojectmanagement.infrastructure.persistence.jpa.repositories.DueDiligenceProjectRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DueDiligenceProjectQueryServiceImpl implements DueDiligenceProjectQueryService {
    private final DueDiligenceProjectRepository dueDiligenceProjectRepository;

    public DueDiligenceProjectQueryServiceImpl(DueDiligenceProjectRepository dueDiligenceProjectRepository) {
        this.dueDiligenceProjectRepository = dueDiligenceProjectRepository;
    }

    @Override
    public Optional<DueDiligenceProject> handle(GetProjectByIdQuery query) {
        return dueDiligenceProjectRepository.findById(query.projectId());
    }

    @Override
    public List<DueDiligenceProject> handle(GetAllProjectsQuery query) {
        return dueDiligenceProjectRepository.findAll();
    }

    @Override
    public List<ProjectMemberItem> handle(GetAllProjectMemberItemByProjectId query) {
        return dueDiligenceProjectRepository.findById(query.projectId()).map(dueDiligenceProject -> dueDiligenceProject.getProjectMember().getAllProjectMemberItems()).orElse(Collections.emptyList());
    }

    @Override
    public Optional<ProjectMemberItem> handle(GetProjectMemberItemByProjectIdAndAgentId query) {
        return dueDiligenceProjectRepository.findById(query.projectId()).map(dueDiligenceProject -> dueDiligenceProject.getProjectMember().getProjectMemberItemWithAgentRecordId(query.agentId()));
    }
}
