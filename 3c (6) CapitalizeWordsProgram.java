import java.util.Scanner;

public class CapitalizeWordsProgram {

    // user defined function to capitalize first letter of each word
    public static String capitalizeWords(String str) {

        // split the string into words using space
        String[] words = str.split(" ");

        // variable to store result
        String result = "";

        // loop through each word
        for(String word : words) {

            if(word.length() > 0) {

                // convert first character to uppercase
                // substring(0,1) gives first letter
                // substring(1) gives remaining letters
                String capitalized =
                        word.substring(0,1).toUpperCase()
                        + word.substring(1).toLowerCase();

                // add to result string with space
                result = result + capitalized + " ";
            }
        }

        // trim() removes extra space at end
        return result.trim();
    }

    public static void main(String[] args) {

        // scanner for user input
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        // calling function
        String output = capitalizeWords(input);

        // display result
        System.out.println("After Capitalizing: " + output);

        sc.close();
    }
}