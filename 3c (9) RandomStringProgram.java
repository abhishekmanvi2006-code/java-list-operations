import java.util.Scanner;
import java.util.Random;

public class RandomStringProgram {

    // user defined function to generate random string
    public static String generateRandomString(int length) {

        // characters allowed in random string
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Random class object
        Random rand = new Random();

        // StringBuilder for efficient string creation
        StringBuilder result = new StringBuilder();

        // loop to generate random characters
        for (int i = 0; i < length; i++) {

            // generate random index
            int index = rand.nextInt(characters.length());

            // append random character to result
            result.append(characters.charAt(index));
        }

        // return generated string
        return result.toString();
    }

    public static void main(String[] args) {

        // scanner for user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter length of random string: ");
        int length = sc.nextInt();

        // calling function
        String randomString = generateRandomString(length);

        // display result
        System.out.println("Random String: " + randomString);

        // close scanner
        sc.close();
    }
}