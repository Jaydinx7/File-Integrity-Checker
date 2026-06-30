import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Scanner;

public class IntegrityChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the file you want to check: ");
        String filePath = scanner.nextLine();

       try{
           System.out.println("File path recieved: " + filePath);
           MessageDigest digest = MessageDigest.getInstance("SHA-256");
           String fileHash = generateFileHash(digest, filePath);

           System.out.println("\n[+] SUCCESS!");
           System.out.println("Algorithm: SHA-256");
           System.out.println("Hash: " + fileHash);
       } catch (Exception e) {
           System.out.println("ERROR: Something went wrong.");
       }

       scanner.close();
    }

    private static String generateFileHash(MessageDigest digest, String filePath) throws IOException {
        FileInputStream fis = new FileInputStream(filePath);

        byte[] byteArray = new byte[1024];
        int bytesCount = 0;

        while ((bytesCount = fis.read(byteArray)) != -1) {
            digest.update(byteArray, 0, bytesCount);
        }
        fis.close();

        // Convert the raw bytes to a readable Hex string
        byte[] bytes = digest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString();
    }
}
