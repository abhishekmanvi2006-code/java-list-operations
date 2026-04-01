import java.util.ArrayList;

public class RemoveColor {
    public static void main(String[] args) {

        // Creating an ArrayList to store colors
        ArrayList<String> colors = new ArrayList<>();

        // Adding elements to ArrayList
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        colors.add("Black");

        // Displaying original list
        System.out.println("Original colors list: " + colors);

        // Removing the 2nd element (index starts from 0, so index 1 is 2nd element)
        colors.remove(1);

        // Displaying list after removing 2nd element
        System.out.println("After removing 2nd element: " + colors);

        // Removing specific color "Blue"
        colors.remove("Blue");

        // Displaying list after removing color Blue
        System.out.println("After removing color Blue: " + colors);
    }
}