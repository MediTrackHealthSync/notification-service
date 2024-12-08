package com.healthsync.notification_service.repository;

import com.healthsync.notification_service.model.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, String> {
    // Additional query methods can be added if needed
}
