package arraylist;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TabbedPaneColorDemo {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Tabbed Pane Color Demo");

        // Create TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels for each color
        JPanel redPanel = new JPanel();
        JPanel bluePanel = new JPanel();
        JPanel greenPanel = new JPanel();

        // Set background colors
        redPanel.setBackground(Color.RED);
        bluePanel.setBackground(Color.BLUE);
        greenPanel.setBackground(Color.GREEN);

        // Add tabs
        tabbedPane.addTab("RED", redPanel);
        tabbedPane.addTab("BLUE", bluePanel);
        tabbedPane.addTab("GREEN", greenPanel);

        // Event when tab changes
        tabbedPane.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {

                int index = tabbedPane.getSelectedIndex();

                if(index == 0)
                    System.out.println("RED tab selected");

                else if(index == 1)
                    System.out.println("BLUE tab selected");

                else
                    System.out.println("GREEN tab selected");
            }
        });

        // Add tabbed pane to frame
        frame.add(tabbedPane);

        // Frame size
        frame.setSize(400, 300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }
}