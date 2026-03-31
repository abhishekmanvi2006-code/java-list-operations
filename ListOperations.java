package arraylist;

import java.util.*;

public class arraylist {

    // 1. Adding elements
    static void addElements(List<String> list) {
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");
        System.out.println("After adding elements: " + list);
    }

    // 2. Adding element at specific index
    static void addAtIndex(List<String> list) {
        list.add(1, "Mango");
        System.out.println("After adding at index 1: " + list);
    }

    // 3. Adding multiple elements
    static void addMultiple(List<String> list) {
        List<String> moreFruits = Arrays.asList("Grapes", "Pineapple");
        list.addAll(moreFruits);
        System.out.println("After adding multiple elements: " + list);
    }

    // 4. Accessing elements
    static void accessElement(List<String> list) {
        System.out.println("Element at index 2: " + list.get(2));
    }

    // 5. Updating elements
    static void updateElement(List<String> list) {
        list.set(0, "Kiwi");
        System.out.println("After updating index 0: " + list);
    }

    // 6. Removing elements
    static void removeElement(List<String> list) {
        list.remove("Banana");
        System.out.println("After removing Banana: " + list);
    }

    // 7. Searching elements
    static void searchElement(List<String> list) {
        System.out.println("Contains Orange? " + list.contains("Orange"));
    }

    // 8. List size
    static void listSize(List<String> list) {
        System.out.println("List size: " + list.size());
    }

    // 9. Iterating over list
    static void iterateList(List<String> list) {
        System.out.print("Using for-each loop: ");
        for(String fruit : list) {
            System.out.print(fruit + " ");
        }
        System.out.println();
    }

    // 10. Using Iterator
    static void useIterator(List<String> list) {
        System.out.print("Using Iterator: ");
        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
    }

    // 11. Sorting
    static void sortList(List<String> list) {
        Collections.sort(list);
        System.out.println("After sorting: " + list);
    }

    // 12. Sublist
    static void subList(List<String> list) {
        System.out.println("Sublist (0 to 2): " + list.subList(0, 2));
    }

    // 13. Clearing the list
    static void clearList(List<String> list) {
        list.clear();
        System.out.println("After clearing list: " + list);
    }

    public static void main(String[] args) {

        System.out.println("===== ArrayList Operations =====");
        List<String> arrayList = new ArrayList<>();

        addElements(arrayList);
        addAtIndex(arrayList);
        addMultiple(arrayList);
        accessElement(arrayList);
        updateElement(arrayList);
        removeElement(arrayList);
        searchElement(arrayList);
        listSize(arrayList);
        iterateList(arrayList);
        useIterator(arrayList);
        sortList(arrayList);
        subList(arrayList);
        clearList(arrayList);

        System.out.println("\n===== LinkedList Operations =====");
        List<String> linkedList = new LinkedList<>();

        addElements(linkedList);
        addAtIndex(linkedList);
        addMultiple(linkedList);
        accessElement(linkedList);
        updateElement(linkedList);
        removeElement(linkedList);
        searchElement(linkedList);
        listSize(linkedList);
        iterateList(linkedList);
        useIterator(linkedList);
        sortList(linkedList);
        subList(linkedList);
        clearList(linkedList);
    }
}