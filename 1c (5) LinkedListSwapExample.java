import java.util.LinkedList;
import java.util.Collections;

public class LinkedListSwapExample {
    public static void main(String[] args) {
        // Create a LinkedList and add some elements
        LinkedList<String> l_list = new LinkedList<>();
        l_list.add("Red");      // 0th element
        l_list.add("Blue");     // 1st element
        l_list.add("Green");    // 2nd element
        l_list.add("Yellow");   // 3rd element

        System.out.println("Original LinkedList: " + l_list);

        // Swap first (index 0) and third (index 2) elements
        Collections.swap(l_list, 0, 2);

        System.out.println("LinkedList after swapping first and third elements: " + l_list);
    }
}