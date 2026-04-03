import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListIteratorExample {
    public static void main(String[] args) {
        // Create a LinkedList and add some elements
        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add("Date");
        list.add("Elderberry");

        // Create a ListIterator starting from the 2nd element (index 1)
        ListIterator<String> iterator = list.listIterator(1);

        System.out.println("Iterating from 2nd element onwards:");
        // Iterate through the list
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}