package com.deltatech.diligencetech.platform.communications.interfaces.rest;

import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetAllNotificationsQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetNotificationByIdQuery;
import com.deltatech.diligencetech.platform.communications.domain.model.queries.GetNotificationsByAgentIdQuery;
import com.deltatech.diligencetech.platform.communications.domain.services.NotificationCommandService;
import com.deltatech.diligencetech.platform.communications.domain.services.NotificationQueryService;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.resources.CreateNotificationResource;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.resources.NotificationResource;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.transform.CreateNotificationCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.communications.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(value = "api/v1/notifications", produces = APPLICATION_JSON_VALUE)
@Tag(name = "Notification")

public class NotificationController {
    private final NotificationQueryService notificationQueryService;

    private final NotificationCommandService notificationCommandService;

    public NotificationController(NotificationQueryService notificationQueryService, NotificationCommandService notificationCommandService) {
        this.notificationQueryService = notificationQueryService;
        this.notificationCommandService = notificationCommandService;
    }

    @GetMapping
    public ResponseEntity<List<NotificationResource>> getAllNotifications() {
        var getAllNotificationsQuery = new GetAllNotificationsQuery();
        var notifications = notificationQueryService.handle(getAllNotificationsQuery);
        var notificationsResources = notifications.stream()
                .map(NotificationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(notificationsResources);
    }
    @GetMapping("/{notificationId}")
    public ResponseEntity<NotificationResource> getNotificationById(@PathVariable Long notificationId) {
        var getNotificationByIdQuery = new GetNotificationByIdQuery(notificationId);
        var notification = notificationQueryService.handle(getNotificationByIdQuery);
        if (notification.isEmpty()) return ResponseEntity.notFound().build();
        var notificationResource = NotificationResourceFromEntityAssembler.toResourceFromEntity(notification.get());
        return ResponseEntity.ok(notificationResource);
    }
    @PostMapping
    public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource resource) {
        var createNotificationCommand = CreateNotificationCommandFromResourceAssembler.toCommandFromResource(resource);
        var notification = notificationCommandService.handle(createNotificationCommand);
        if (notification.isEmpty()) return ResponseEntity.badRequest().build();
        var notificationResource = NotificationResourceFromEntityAssembler.toResourceFromEntity(notification.get());
        return new ResponseEntity<>(notificationResource, HttpStatus.CREATED);
    }
    @GetMapping("/agent_id")
    public ResponseEntity<List<NotificationResource>> getNotificationByAgentId(@RequestParam Long agentId) {
        var getNotificationsByAgentIdQuery = new GetNotificationsByAgentIdQuery(agentId);
        var notifications = notificationQueryService.handle(getNotificationsByAgentIdQuery);
        var notificationsResources = notifications.stream()
                .map(NotificationResourceFromEntityAssembler::toResourceFromEntity)
                .toList();
        return ResponseEntity.ok(notificationsResources);
    }



}
