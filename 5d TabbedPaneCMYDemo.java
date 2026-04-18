package arraylist;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TabbedPaneCMYDemo {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("CMY Tabbed Pane");

        // Create tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Create panels
        JPanel cyanPanel = new JPanel();
        JPanel magentaPanel = new JPanel();
        JPanel yellowPanel = new JPanel();

        // Set background colors
        cyanPanel.setBackground(Color.CYAN);
        magentaPanel.setBackground(Color.MAGENTA);
        yellowPanel.setBackground(Color.YELLOW);

        // Add tabs
        tabbedPane.addTab("CYAN", cyanPanel);
        tabbedPane.addTab("MAGENTA", magentaPanel);
        tabbedPane.addTab("YELLOW", yellowPanel);

        // Event listener for tab change
        tabbedPane.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {

                int index = tabbedPane.getSelectedIndex();

                if(index == 0)
                    System.out.println("CYAN tab selected");

                else if(index == 1)
                    System.out.println("MAGENTA tab selected");

                else
                    System.out.println("YELLOW tab selected");
            }
        });

        // Add tabbed pane to frame
        frame.add(tabbedPane);

        // Frame size
        frame.setSize(400, 300);

        // Close operation
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Visible
        frame.setVisible(true);
    }
}