package org.example.JCA;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;


public class SymmetricEncryptionExample {
    public static void main(String[] args) throws Exception {
        // Generate a symmetric key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

        // Encrypt
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal("Hello, World!".getBytes());
        String encryptedMessage = Base64.getEncoder().encodeToString(encrypted);
        System.out.println("Encrypted Message: " + encryptedMessage);
        System.out.println("Encrypted: " + new String(encrypted));

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(encrypted);
        System.out.println("Decrypted: " + new String(decrypted));
    }
}
