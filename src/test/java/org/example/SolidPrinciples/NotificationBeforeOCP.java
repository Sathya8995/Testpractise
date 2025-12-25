package org.example.SolidPrinciples;

public class NotificationBeforeOCP {
    public void sendNotification(String type) {
        if (type.equals("Email")) {
            System.out.println("Sending email notification...");
        } else if (type.equals("SMS")) {
            System.out.println("Sending SMS notification...");
        }
        else if(type.equals("OTP"))
        {
            System.out.println("Sending OTP notification...");
        }
        else if(type.equals("CALLOTP"))
        {
            System.out.println("Sending Call OTP notification...");
        }
    }
}
