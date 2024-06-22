package com.deltatech.diligencetech.platform.communications.infrastructure.persistence.jpa.repositories;

import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailRepository extends JpaRepository<Email, Long> {

    List<Email> findByReceiverId(Long receiverId);
    List<Email> findBySenderId(Long senderId);

}
