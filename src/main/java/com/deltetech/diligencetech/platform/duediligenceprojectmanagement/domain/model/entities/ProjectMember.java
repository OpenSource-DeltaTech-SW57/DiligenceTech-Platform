package com.deltetech.diligencetech.platform.duediligenceprojectmanagement.domain.model.entities;

import com.deltetech.diligencetech.platform.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity
public class ProjectMember extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID id;
}
