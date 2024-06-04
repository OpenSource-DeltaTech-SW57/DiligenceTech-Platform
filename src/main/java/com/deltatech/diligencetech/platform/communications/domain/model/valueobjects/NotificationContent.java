package com.deltatech.diligencetech.platform.communications.domain.model.valueobjects;
import jakarta.persistence.Embeddable;
import java.util.UUID;

@Embeddable
public record NotificationContent(String notificationContent){

    public NotificationContent(){
        this(UUID.randomUUID().toString());
    }

    public NotificationContent{
        if (notificationContent == null || notificationContent.isBlank()){
            throw new IllegalArgumentException("fool, u cant do that!, 
            Notification Content cannot be null nor blank")
        }
    }
}


/*
 * 
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