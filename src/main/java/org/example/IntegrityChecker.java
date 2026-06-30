package org.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Scanner;

public class IntegrityChecker {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the file you want to check: ");
        String filePath = scanner.nextLine();

       try{
           System.out.println("File path recieved: " + filePath);
       } catch (Exception e) {
           System.out.println("ERROR: Something went wrong.");
       }

       scanner.close();
    }

    private static byte[] generateFileHash(MessageDigest digest, String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);

        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        }
        fis.close();

        return digest.digest();
    }
}
