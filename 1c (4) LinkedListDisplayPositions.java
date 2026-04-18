import java.util.LinkedList;

public class LinkedListDisplayPositions {
    public static void main(String[] args) {
        // Create a LinkedList and add some elements
        LinkedList<String> l_list = new LinkedList<>();
        l_list.add("Red");
        l_list.add("Blue");
        l_list.add("Green");
        l_list.add("Yellow");
        l_list.add("Pink");

        System.out.println("Elements and their positions in the LinkedList:");

        // Loop through the list using index
        for (int p = 0; p < l_list.size(); p++) {
            System.out.println("Position " + p + ": " + l_list.get(p));
        }
    }
}