package org.example.JCA;
import java.time.*;
import java.time.format.DateTimeFormatter;


public class Date_Time_Zone {
    public static void main(String[] args) {
        // Create a LocalDateTime object representing the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();

        // Print the current date and time
        System.out.println("Current date and time: " + currentDateTime + "  Current time: " + localTime);

        //System.out.println("Current time: " + localTime);

        System.out.println("Current date: " + localDate);

        // Define the pattern for formatting
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        // Format the LocalDate to a string
        String formattedDate = localDate.format(formatter);

        // Print the formatted date
        System.out.println("Formatted date: " + formattedDate);

        //Zone
        ZoneId indiaZone = ZoneId.of("Asia/Kolkata");
        ZonedDateTime indiaDateTime = ZonedDateTime.now(indiaZone);

        System.out.println("IST: " + indiaDateTime);

        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println("defaultZone: " + defaultZone);

        ZoneId newYorkZone = ZoneId.of("America/New_York");
        ZonedDateTime newYorkTime = indiaDateTime.withZoneSameInstant(newYorkZone);
        System.out.println("newYorkTime: " + newYorkTime);

    }
}
