import java.util.Scanner;

public class CountSubstringOccurrences {

    // user defined function
    public static int countOccurrences(String mainStr, String subStr) {
        int count = 0;
        int index = 0;

        while ((index = mainStr.indexOf(subStr, index)) != -1) {
            count++;
            index = index + subStr.length(); // move forward
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter main string: ");
        String mainStr = sc.nextLine();

        System.out.print("Enter substring to search: ");
        String subStr = sc.nextLine();

        int result = countOccurrences(mainStr, subStr);

        System.out.println("Substring appears " + result + " time(s).");

        sc.close();
    }
}