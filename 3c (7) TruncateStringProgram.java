import java.util.Scanner;

public class TruncateStringProgram {

    // user defined function to truncate string
    public static String truncate(String str, int maxLength) {

        // check if string length is greater than specified length
        if (str.length() > maxLength) {

            // substring from 0 to maxLength and add ellipsis
            return str.substring(0, maxLength) + "...";
        }

        // if string length is within limit, return original string
        return str;
    }

    public static void main(String[] args) {

        // scanner object for input
        Scanner sc = new Scanner(System.in);

        // get string from user
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // get maximum length from user
        System.out.print("Enter maximum length: ");
        int length = sc.nextInt();

        // calling user defined function
        String result = truncate(input, length);

        // display output
        System.out.println("Truncated String: " + result);

        // close scanner
        sc.close();
    }
}