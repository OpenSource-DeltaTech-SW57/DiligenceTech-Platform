package com.deltatech.diligencetech.platform.duediligence.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.duediligence.domain.model.aggregates.InformationGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InformationGroupRepository extends JpaRepository<InformationGroup, Long> {
    Optional<InformationGroup> findByParentAndIdentifier(String parent, String identifier);
}