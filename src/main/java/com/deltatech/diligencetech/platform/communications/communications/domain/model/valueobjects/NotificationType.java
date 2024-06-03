package com.deltatech.diligencetech.platform.communications.domain.model.valueobjects;
import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record NotificationType(String notificationType){
    public NotificationType(){
        this(UUID.randomUUID().toString());
    }
    public NotificationType{
        if (notificationType == null || notificationType.isBlank()){
            throw new IllegalArgumentException("w r u so dumb??, 
            Notification type cannot be null nor blank")
        }
    }
}

/*
 * package com.deltatech.diligencetech.platform.communications.domain.model.valueobjects;
import jakarta.persistence.Embeddable;

import java.util.Date;
import java.util.UUID;

@Embeddable
public record NotificationPublishedDate (Date notificationPublishedDate){

    public NotificationPublishedDate(){
        this(UUID.randomUUID().toString());
    }

    public NotificationPublishedDate{
        if (notificationPublishedDate == null || notificationPublishedDate.isBlank()){
            throw new IllegalArgumentException("Notification published date cannot be null or blank");
        }
    }

}
 */