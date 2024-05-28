package com.deltatech.diligencetech.platform.qa.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
