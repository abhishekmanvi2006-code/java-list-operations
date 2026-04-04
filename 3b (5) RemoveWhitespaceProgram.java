import java.util.Scanner;

public class RemoveWhitespaceProgram {

    // user defined function to remove all whitespace characters
    public static String removeWhitespace(String str) {

        // replace all whitespace (spaces, tabs, newline) with empty string
        String result = str.replaceAll("\\s", "");

        // return modified string
        return result;
    }

    public static void main(String[] args) {

        // scanner object for user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // calling user defined function
        String output = removeWhitespace(input);

        // displaying result
        System.out.println("String after removing whitespace: " + output);

        // closing scanner
        sc.close();
    }
}