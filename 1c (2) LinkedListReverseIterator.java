import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListReverseIterator {
    public static void main(String[] args) {
        // Create a LinkedList and add some elements
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");

        // Create a descending iterator
        Iterator<String> descendingIterator = list.descendingIterator();

        System.out.println("Iterating in reverse order:");
        // Iterate through the list in reverse
        while (descendingIterator.hasNext()) {
            System.out.println(descendingIterator.next());
        }
    }
}