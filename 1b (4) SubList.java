import java.util.ArrayList;
import java.util.List;

public class SubListExample {
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

        // Extracting 1st and 2nd elements using subList()
        // index starts from 0, so 0 and 1 are first two elements
        List<String> subListColors = colors.subList(0, 2);

        // Display sublist
        System.out.println("Extracted elements (1st and 2nd): " + subListColors);
    }
}