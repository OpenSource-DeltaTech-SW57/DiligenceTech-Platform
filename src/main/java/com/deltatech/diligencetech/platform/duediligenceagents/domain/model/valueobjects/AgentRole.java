package com.deltatech.diligencetech.platform.duediligenceagents.domain.model.valueobjects;

import com.deltatech.diligencetech.platform.duediligenceprojectmanagement.domain.model.aggregates.Project;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class AgentRole {

    @OneToMany
    private List<Project> projects;


    public AgentRole() {
        this.projects = new ArrayList<>();
    }

}
