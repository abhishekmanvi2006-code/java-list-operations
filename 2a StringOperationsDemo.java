import java.util.Scanner;

public class StringOperationsDemo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. String Creation and Basic Operations
        String str1 = "Hello";
        String str2 = new String("World");
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);

        // 2. Length and Character Access
        System.out.println("Length of str1: " + str1.length());
        System.out.println("Character at index 1 of str1: " + str1.charAt(1));

        // 3. String Comparison
        System.out.println("str1 equals str2? " + str1.equals(str2));
        System.out.println("str1 equalsIgnoreCase 'hello'? " + str1.equalsIgnoreCase("hello"));

        // 4. String Searching
        System.out.println("Index of 'l' in str1: " + str1.indexOf('l'));
        System.out.println("Does str1 contain 'lo'? " + str1.contains("lo"));

        // 5. Substring Operations
        System.out.println("Substring of str1 (1,4): " + str1.substring(1, 4));

        // 6. String Modification
        String modifiedStr = str1.replace('l', 'p');
        System.out.println("Modified str1 replacing 'l' with 'p': " + modifiedStr);
        System.out.println("Uppercase str1: " + str1.toUpperCase());
        System.out.println("Lowercase str1: " + str1.toLowerCase());

        // 7. Whitespace Handling
        String strWithSpaces = "   Java Programming   ";
        System.out.println("Original: '" + strWithSpaces + "'");
        System.out.println("Trimmed: '" + strWithSpaces.trim() + "'");

        // 8. String Concatenation
        String concatenated = str1 + " " + str2;
        System.out.println("Concatenated String: " + concatenated);
        System.out.println("Using concat(): " + str1.concat(" ").concat(str2));

        // 9. String Splitting
        String sentence = "Java is fun";
        String[] words = sentence.split(" ");
        System.out.println("Splitting sentence:");
        for(String word : words) {
            System.out.println(word);
        }

        // 10. StringBuilder Demo
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" World");
        sb.insert(6, "Java ");
        sb.replace(0, 5, "Hi");
        sb.delete(3, 8);
        System.out.println("StringBuilder result: " + sb.toString());

        // 11. String Formatting
        String name = "Abhishek";
        int age = 17;
        String formatted = String.format("My name is %s and I am %d years old.", name, age);
        System.out.println(formatted);

        // 12. Validate Email using contains(), startsWith(), endsWith()
        System.out.print("Enter email to validate: ");
        String email = sc.nextLine();
        if(email.contains("@") && email.endsWith(".com") && email.startsWith("a")) {
            System.out.println("Email is valid according to the given rules.");
        } else {
            System.out.println("Email is invalid according to the given rules.");
        }

        sc.close();
    }
}