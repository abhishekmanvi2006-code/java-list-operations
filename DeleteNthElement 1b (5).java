import java.util.ArrayList;
import java.util.Scanner;

public class DeleteNthElement {
    public static void main(String[] args) {

        // Creating ArrayList to store colors
        ArrayList<String> colors = new ArrayList<>();

        // Adding colors to the list
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Black");

        // Display original list
        System.out.println("Original List: " + colors);

        // Taking input for nth position
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter index number to delete element: ");
        int n = sc.nextInt();

        // Removing nth element using remove(index)
        if(n >= 0 && n < colors.size()) {
            colors.remove(n);
            System.out.println("List after removing element at index " + n + ": " + colors);
        } else {
            System.out.println("Invalid index!");
        }

        sc.close();
    }
}