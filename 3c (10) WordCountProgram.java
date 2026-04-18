import java.util.Scanner;

public class WordCountProgram {

    // user defined function to count words
    public static int countWords(String str) {

        // remove extra spaces at beginning and end
        str = str.trim();

        // check if string is empty after trimming
        if (str.isEmpty()) {
            return 0;
        }

        // split string using one or more whitespace characters
        String[] words = str.split("\\s+");

        // return number of words
        return words.length;
    }

    public static void main(String[] args) {

        // scanner object for user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // calling user defined function
        int wordCount = countWords(input);

        // display result
        System.out.println("Number of words: " + wordCount);

        // close scanner
        sc.close();
    }
}