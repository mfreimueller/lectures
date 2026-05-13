# Kata 3: DIP -- Notification System

| Field | Value |
|-------|-------|
| Concepts | DIP, dependency injection, abstraction |
| Difficulty | 3/5 |
| Duration | approx. 25 min |

### Task

The following code violates DIP. Refactor it using an abstraction and dependency injection.

```java
class EmailSender {
    void sendEmail(String message) {
        System.out.println("Sending email: " + message);
    }
}

class SmsSender {
    void sendSms(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

class NotificationService {
    private EmailSender emailSender = new EmailSender();
    private SmsSender smsSender = new SmsSender();

    void notifyByEmail(String message) {
        emailSender.sendEmail(message);
    }

    void notifyBySms(String message) {
        smsSender.sendSms(message);
    }
}
```

Requirements:
- Create a `MessageSender` interface with `void send(String message)`
- Create `EmailSender` and `SmsSender` implementations
- Refactor `NotificationService` to use constructor injection with `MessageSender`
- The service should support any MessageSender implementation

### Extension

Add a `PushNotificationSender` without modifying NotificationService.
