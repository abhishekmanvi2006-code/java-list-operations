package arraylist;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class CountryJListDemo {

    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("Country List");

        // Array of countries
        String countries[] = {
                "USA", "India", "Vietnam", "Canada",
                "Denmark", "France", "Great Britain",
                "Japan", "Africa", "Greenland", "Singapore"
        };

        // Create JList
        JList<String> countryList = new JList<>(countries);

        // Allow multiple selection
        countryList.setSelectionMode(
                ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        // Scroll pane for JList
        JScrollPane scrollPane = new JScrollPane(countryList);

        // Event listener
        countryList.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {

                // get selected values
                java.util.List<String> selectedCountries =
                        countryList.getSelectedValuesList();

                // print in console
                System.out.println("Selected Countries: " + selectedCountries);
            }
        });

        // layout
        frame.setLayout(new BorderLayout());

        frame.add(scrollPane, BorderLayout.CENTER);

        // frame size
        frame.setSize(300, 250);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}