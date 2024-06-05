package com.deltatech.diligencetech.platform.communications.infrastructure.persistence.jpa.repositories;


import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long>{

}