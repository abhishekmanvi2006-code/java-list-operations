public class StringOperationsDemo {
    public static void main(String[] args) {

        // 1. String Creation and Basic Operations
        String str1 = "Hello";
        String str2 = "World";
        String str3 = "  Java Programming  ";

        System.out.println("Original Strings:");
        System.out.println("str1 = " + str1);
        System.out.println("str2 = " + str2);
        System.out.println("str3 = " + str3);

        // 2. Length and Character Access
        System.out.println("\nLength of str1: " + str1.length());
        System.out.println("Character at index 1 in str1: " + str1.charAt(1));

        // 3. String Comparison
        String str4 = "hello";
        System.out.println("\nstr1 equals str4? " + str1.equals(str4));
        System.out.println("str1 equalsIgnoreCase str4? " + str1.equalsIgnoreCase(str4));

        // 4. String Searching
        String text = "Java Programming Language";
        System.out.println("\nIndex of 'Programming': " + text.indexOf("Programming"));
        System.out.println("Contains 'Java'? " + text.contains("Java"));

        // 5. Substring Operations
        System.out.println("\nSubstring from index 5: " + text.substring(5));
        System.out.println("Substring (5 to 16): " + text.substring(5, 16));

        // 6. String Modification
        System.out.println("\nReplace Java with Python: " + text.replace("Java", "Python"));
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());

        // 7. Whitespace Handling
        System.out.println("\nTrimmed str3: '" + str3.trim() + "'");

        // 8. String Concatenation
        String concat = str1 + " " + str2;
        System.out.println("\nConcatenated String: " + concat);
        System.out.println("Using concat(): " + str1.concat(" ").concat(str2));

        // 9. String Splitting
        String sentence = "Java is easy to learn";
        String[] words = sentence.split(" ");

        System.out.println("\nSplitting sentence into words:");
        for(String word : words) {
            System.out.println(word);
        }

        // 10. StringBuilder Demo
        StringBuilder sb = new StringBuilder("AIET");
        for(int i = 0; i < 5; i++) {
            sb.append(" College");
        }
        System.out.println("\nStringBuilder Output: " + sb);

        // 11. String Formatting
        String name = "Abhi";
        int marks = 95;
        String formatted = String.format("Student %s scored %d marks.", name, marks);
        System.out.println("\nFormatted String: " + formatted);

        // 12. Validate Email using contains(), startsWith(), endsWith()
        String email = "example@gmail.com";

        if(email.contains("@") && email.contains(".")
                && !email.startsWith("@")
                && email.endsWith(".com")) {

            System.out.println("\nEmail is valid: " + email);
        }
        else {
            System.out.println("\nInvalid Email: " + email);
        }
    }
}