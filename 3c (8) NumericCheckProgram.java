import java.util.Scanner;

public class NumericCheckProgram {

    // user defined function to check if string contains only numbers
    public static boolean isNumeric(String str) {

        // check each character of string
        for (int i = 0; i < str.length(); i++) {

            // Character.isDigit() returns true if character is a digit (0-9)
            if (!Character.isDigit(str.charAt(i))) {

                // if any character is not digit, return false
                return false;
            }
        }

        // if all characters are digits, return true
        return true;
    }

    public static void main(String[] args) {

        // scanner object for user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // calling user defined function
        if (isNumeric(input)) {
            System.out.println("The string contains only numeric characters.");
        } else {
            System.out.println("The string does NOT contain only numeric characters.");
        }

        // close scanner
        sc.close();
    }
}