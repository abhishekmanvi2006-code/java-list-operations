import java.util.Scanner;

public class PalindromeCheck {

    // user defined function to check palindrome
    public static boolean isPalindrome(String str) {

        // remove punctuation and spaces using regex
        // keep only letters and numbers
        String cleaned = str.replaceAll("[^a-zA-Z0-9]", "");

        // convert to lowercase to ignore case difference
        cleaned = cleaned.toLowerCase();

        // reverse the cleaned string
        String reversed = "";

        for(int i = cleaned.length() - 1; i >= 0; i--) {
            reversed = reversed + cleaned.charAt(i);
        }

        // check if original cleaned string equals reversed string
        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {

        // scanner for user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // calling function
        if(isPalindrome(input)) {
            System.out.println("The string is a Palindrome.");
        }
        else {
            System.out.println("The string is NOT a Palindrome.");
        }

        sc.close();
    }
}