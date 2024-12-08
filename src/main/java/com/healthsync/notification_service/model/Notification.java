package com.healthsync.notification_service.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Data
@Document(collection = "notifications")
public class Notification {

    @Id
    private String id;
    private String notificationType; // e.g., "Appointment Reminder" or "Follow-Up Notification"
    private String patientName;
    private String doctorName;
    private String appointmentDate; // Format: "YYYY-MM-DD"
    private String appointmentTime; // Format: "HH:mm"
    private String reminderMessage;
}
