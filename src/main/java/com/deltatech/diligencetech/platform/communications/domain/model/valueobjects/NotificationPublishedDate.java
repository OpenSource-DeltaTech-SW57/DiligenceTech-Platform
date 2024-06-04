package com.deltatech.diligencetech.platform.communications.domain.model.valueobjects;
import jakarta.persistence.Embeddable;

import java.util.Date;
import java.util.UUID;

@Embeddable
public record NotificationPublishedDate(Date notificationPublishedDate){

    public NotificationPublishedDate(){
        this(UUID.randomUUID().toString());
    }

    public NotificationPublishedDate{
        if (notificationPublishedDate == null || notificationPublishedDate.isBlank()){
            throw new IllegalArgumentException("Notification published date cannot be null nor blank");
        }
    }

}

/*
 * package com.acme.center.platform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public record AcmeStudentRecordId(String studentRecordId) {
    public AcmeStudentRecordId() {
        this(UUID.randomUUID().toString());
    }

    public AcmeStudentRecordId {
        if (studentRecordId == null || studentRecordId.isBlank()) {
            throw new IllegalArgumentException("Acme student record profileId cannot be null or blank");
        }
    }
}

 */