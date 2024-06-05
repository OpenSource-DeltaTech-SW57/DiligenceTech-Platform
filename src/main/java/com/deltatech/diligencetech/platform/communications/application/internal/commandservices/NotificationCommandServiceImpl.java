package com.deltatech.diligencetech.platform.communications.application.internal.commandservices;

import com.deltatech.diligencetech.platform.communications.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.communications.domain.model.commands.CreateNotificationCommand;
import com.deltatech.diligencetech.platform.communications.domain.model.commands.DeleteNotificationCommand;
import com.deltatech.diligencetech.platform.communications.domain.services.NotificationCommandService;
import com.deltatech.diligencetech.platform.communications.infrastructure.persistence.jpa.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class NotificationCommandServiceImpl implements NotificationCommandService {

    private final NotificationRepository notificationRepository;


    public NotificationCommandServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Optional<Notification> handle(CreateNotificationCommand command) {

        var notification = new Notification(command);
        notificationRepository.save(notification);
        return Optional.of(notification);

    }

    @Override
    public void handle(DeleteNotificationCommand command) {
        if (!notificationRepository.existsById(command.notificationId())) {
            throw new IllegalArgumentException("Notification does not exist");
        }
        try {
            notificationRepository.deleteById(command.notificationId());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while deleting Notification: " + e.getMessage());
        }
    }
}
