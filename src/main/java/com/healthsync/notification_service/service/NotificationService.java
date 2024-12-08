package com.healthsync.notification_service.service;

import com.healthsync.notification_service.model.Notification;

import java.util.List;
import java.util.Optional;

public interface NotificationService {
    Notification createNotification(Notification notification);

    List<Notification> getAllNotifications();

    Optional<Notification> getNotificationById(String id);

    Notification updateNotification(String id, Notification notification);

    void deleteNotification(String id);
}
