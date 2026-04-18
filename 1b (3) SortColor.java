import java.util.ArrayList;
import java.util.Collections;

public class SortColors {
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

        // Sorting the ArrayList using Collections.sort()
        Collections.sort(colors);

        // Display sorted list
        System.out.println("Sorted List: " + colors);
    }
}