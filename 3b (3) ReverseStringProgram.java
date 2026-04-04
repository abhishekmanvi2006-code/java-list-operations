import java.util.Scanner;

public class ReverseStringProgram {

    // User defined function to reverse a string
    public static String reverseString(String str) {

        // variable to store reversed string
        String reversed = "";

        // loop starts from last character and moves to first
        for (int i = str.length() - 1; i >= 0; i--) {

            // charAt(i) returns character at index i
            // characters are added one by one in reverse order
            reversed = reversed + str.charAt(i);
        }

        // returning reversed string
        return reversed;
    }

    public static void main(String[] args) {

        // Scanner object to take input from user
        Scanner sc = new Scanner(System.in);

        // asking user to enter string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // calling user defined function
        String result = reverseString(input);

        // displaying reversed string
        System.out.println("Reversed String: " + result);

        // closing scanner
        sc.close();
    }
}