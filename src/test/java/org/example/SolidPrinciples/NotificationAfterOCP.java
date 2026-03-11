package org.example.SolidPrinciples;

import java.util.Scanner;

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
class NotificationServiceAfterOCP{
    static Notification notification;
    public static void send(String type){
        if (type == null) {
            System.out.println("Unknown notification type: null");
            return;
        }

        switch (type) {
            case "email":
                notification = new EmailNotification();
                break;
            case "sms":
                notification = new SMSNotification();
                break;
            case "otp":
                notification = new OTPNotification();
                break;
            case "callotp":
                notification = new CallNotification();
                break;
            default:
                System.out.println("Unknown notification type: " + type);
                return;
        }
        notification.send();
    }
}

public class NotificationAfterOCP {
    public static void main(String[] args) {
        System.out.println("Enter notification method: email, sms, otp, call");
        Scanner scanner = new Scanner(System.in);
        String type = scanner.next();
        NotificationServiceAfterOCP.send(type.toLowerCase());

    }

}
