package com.healthsync.notification_service.service.impl;

import com.healthsync.notification_service.model.Notification;
import com.healthsync.notification_service.repository.NotificationRepository;
import com.healthsync.notification_service.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository repository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Notification createNotification(Notification notification) {
        return repository.save(notification);
    }

    @Override
    public List<Notification> getAllNotifications() {
        return repository.findAll();
    }

    @Override
    public Optional<Notification> getNotificationById(String id) {
        return repository.findById(id);
    }

    @Override
    public Notification updateNotification(String id, Notification notification) {
        return repository.findById(id)
                .map(existingNotification -> {
                    existingNotification.setNotificationType(notification.getNotificationType());
                    existingNotification.setPatientName(notification.getPatientName());
                    existingNotification.setDoctorName(notification.getDoctorName());
                    existingNotification.setAppointmentDate(notification.getAppointmentDate());
                    existingNotification.setAppointmentTime(notification.getAppointmentTime());
                    existingNotification.setReminderMessage(notification.getReminderMessage());
                    return repository.save(existingNotification);
                })
                .orElseThrow(() -> new RuntimeException("Notification not found with id " + id));
    }

    @Override
    public void deleteNotification(String id) {
        repository.deleteById(id);
    }
}
