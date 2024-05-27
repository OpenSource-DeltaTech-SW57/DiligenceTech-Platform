package com.deltatech.diligencetech.platform.qa.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.qa.domain.model.aggregates.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long>{
}
