package org.example;

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
}
