package com.deltatech.diligencetech.platform.shared.interfaces.rest;

import com.deltatech.diligencetech.platform.shared.domain.model.aggregates.Notification;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetAllNotificationsQuery;
import com.deltatech.diligencetech.platform.shared.domain.model.queries.GetNotificationByIdQuery;
import com.deltatech.diligencetech.platform.shared.domain.services.NotificationCommandService;
import com.deltatech.diligencetech.platform.shared.domain.services.NotificationQueryService;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.resources.NotificationResource;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.transform.NotificationResourceFromEntityAssembler;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.transform.CreateAgentCommandFromResourceAssembler;
import com.deltatech.diligencetech.platform.shared.interfaces.rest.transform.CreateNotificationResource;


import com.deltatech.diligencetech.platform.shared.interfaces.rest.transform.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/v1/notifications")
public class NotificationController {
  private final NotificationQueryService notificationQueryService;
  private final NotificationCommandService notificationCommandService;
  public NotificationController(NotificationQueryService notificationQueryService, NotificationCommandService notificationCommandService) {
    this.notificationQueryService = notificationQueryService;
    this.notificationCommandService = notificationCommandService;
  }

  @PostMapping
  public ResponseEntity<NotificationResource> createNotification(@RequestBody CreateNotificationResource resource) {
    Optional<Notification> notification = notificationCommandService.handle(CreateNotificationCommandFromResourceAssembler.toCommandFromResource(resource));
    return notification.map(source->new ResponseEntity<>(NotificationResourceFromEntityAssembler.toResourceFromEntity(source),CREATED)).orElseGet(()->ResponseEntity.badRequest().build());
  }

  @GetMapping
  public ResponseEntity<List<NotificationResource>> getAllNotifications() {
    var getAllNotificationsQuery = new GetAllNotificationsQuery();
    var notifications = notificationQueryService.handle(getAllNotificationsQuery);
    var notificationsResources = notifications.stream().map(NotificationResourceFromEntityAssembler::toResourceFromEntity).toList();
    return ResponseEntity.ok(notificationsResources);
  }

  @GetMapping("/{id}")
  public ResponseEntity<NotificationResource> getNotificationById(@PathVariable Long id) {
    var getNotificationByIdQuery = new GetNotificationByIdQuery(id);
    var notification = notificationQueryService.handle(getNotificationByIdQuery);
    if(notification.isEmpty())
      return ResponseEntity.notFound().build();
    var notificationResource = NotificationResourceFromEntityAssembler.toResourceFromEntity(notification.get());
    return ResponseEntity.ok(notificationResource);
  }
}