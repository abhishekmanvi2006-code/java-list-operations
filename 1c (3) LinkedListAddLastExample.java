import java.util.LinkedList;

public class LinkedListAddLastExample {
    public static void main(String[] args) {
        // Create a LinkedList and add some elements
        LinkedList<String> l_list = new LinkedList<>();
        l_list.add("Red");
        l_list.add("Blue");
        l_list.add("Green");

        System.out.println("Original LinkedList: " + l_list);

        // Insert "Pink" at the end of the LinkedList
        l_list.offerLast("Pink");

        System.out.println("After adding 'Pink' at the end: " + l_list);
    }
}