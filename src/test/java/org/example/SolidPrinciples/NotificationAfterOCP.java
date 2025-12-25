package org.example.SolidPrinciples;

// Notification.java
interface Notification {
    void send();
}

// EmailNotification.java
class EmailNotification implements Notification {
    public void send() {
        System.out.println("Sending email notification...");
    }
}

// SMSNotification.java
class SMSNotification implements Notification {
    public void send() {
        System.out.println("Sending SMS notification...");
    }
}

class OTPNotification implements Notification
{
    public void send() {
        System.out.println("Sending OTP notification...");
        System.out.println("Change in logic for OTP");
    }
}

class CallNotification implements Notification
{
    public void send() {
        System.out.println("Sending Call notification...");
    }
}



// NotificationService.java
class NotificationServiceAfterOCP {
    public void sendNotification(Notification notification) {

        notification.send();
    }
}

public class NotificationAfterOCP {

}
