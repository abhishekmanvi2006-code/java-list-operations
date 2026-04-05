package arraylist;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.util.HashMap;

public class CountryCapitalJList {

    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("Country Capitals");

        // Country list
        String countries[] = {
                "USA", "India", "Vietnam", "Canada",
                "Denmark", "France", "Great Britain",
                "Japan", "Africa", "Greenland", "Singapore"
        };

        // Capitals stored using HashMap
        HashMap<String, String> capitals = new HashMap<>();

        capitals.put("USA", "Washington D.C.");
        capitals.put("India", "New Delhi");
        capitals.put("Vietnam", "Hanoi");
        capitals.put("Canada", "Ottawa");
        capitals.put("Denmark", "Copenhagen");
        capitals.put("France", "Paris");
        capitals.put("Great Britain", "London");
        capitals.put("Japan", "Tokyo");
        capitals.put("Africa", "No single capital");
        capitals.put("Greenland", "Nuuk");
        capitals.put("Singapore", "Singapore");

        // Create JList
        JList<String> countryList = new JList<>(countries);

        // single selection
        countryList.setSelectionMode(
                ListSelectionModel.SINGLE_SELECTION);

        // Scroll
        JScrollPane scrollPane = new JScrollPane(countryList);

        // Event
        countryList.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {

                    String selectedCountry =
                            countryList.getSelectedValue();

                    String capital =
                            capitals.get(selectedCountry);

                    System.out.println(
                            selectedCountry +
                            " → Capital: " + capital
                    );
                }
            }
        });

        frame.setLayout(new BorderLayout());

        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(300, 250);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}