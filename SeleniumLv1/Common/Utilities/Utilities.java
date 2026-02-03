package Utilities;

import java.nio.file.Paths;
import java.util.Random;
import java.util.UUID;

public class Utilities {
    public static String getProjectPath(){
        return Paths.get("").toAbsolutePath().toString();
    }

    public static String generateRandomString(int length){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder result = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++){
            result.append(characters.charAt(random.nextInt()));        }
        return result.toString();
    }

    public static String generateRandomEmail() {
        return "user_" + UUID.randomUUID().toString().substring(0, 8) + "@example.com";
    }
}
