package org.example.JCA;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECGenParameterSpec;

public class ECKeyPairExample {
    public static void main(String[] args) {
        try {
            // Step 1: Choose the algorithm and initialize the KeyPairGenerator
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("EC");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("secp256r1"); // Specify the curve name
            keyPairGen.initialize(ecSpec);

            // Step 2: Generate the key pair
            KeyPair keyPair = keyPairGen.generateKeyPair();

            // Step 3: Retrieve the public and private keys from the key pair
            java.security.PublicKey publicKey = keyPair.getPublic();
            java.security.PrivateKey privateKey = keyPair.getPrivate();

            // Step 4: Use the keys as needed (e.g., print them out or store them securely)
            System.out.println("Public Key: " + publicKey);
            System.out.println("Private Key: " + privateKey);

        } catch (NoSuchAlgorithmException | java.security.InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
    }
}
