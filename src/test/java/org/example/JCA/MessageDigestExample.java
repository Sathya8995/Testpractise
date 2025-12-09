package org.example.JCA;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestExample {
    public static void main(String[] args) {
        try {
            // Step 1: Obtain a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // Step 2: Provide input data (e.g., a string)
            String input = "Hello, World!";
            byte[] inputBytes = input.getBytes();

            // Step 3: Update the digest with input data
            digest.update(inputBytes);

            // Step 4: Compute the hash (digest)
            byte[] hash = digest.digest();

            // Step 5: Convert the byte array to a hexadecimal string
            String hashHex = bytesToHex(hash);
            System.out.println("SHA-256 Hash: " + hashHex);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert byte array to hexadecimal string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }
}
