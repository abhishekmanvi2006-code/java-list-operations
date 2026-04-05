package arraylist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonEventDemo {

    public static void main(String[] args) {

        // Create frame
        JFrame frame = new JFrame("Image Button Event");

        // Create label (text will appear below buttons)
        JLabel label = new JLabel("Click any image button");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setHorizontalAlignment(JLabel.CENTER);

        // Resize images to same size (100x100)
        ImageIcon clockIcon = new ImageIcon("C:\\Users\\Abhishek\\Downloads\\clock.png");
        Image img1 = clockIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        clockIcon = new ImageIcon(img1);

        ImageIcon hourglassIcon = new ImageIcon("C:\\Users\\Abhishek\\Downloads\\hourglass.png");
        Image img2 = hourglassIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        hourglassIcon = new ImageIcon(img2);

        // Create buttons
        JButton btnClock = new JButton(clockIcon);
        JButton btnHourglass = new JButton(hourglassIcon);

        // Remove button borders (optional, looks better)
        btnClock.setBorderPainted(false);
        btnHourglass.setBorderPainted(false);

        // Action for Clock button
        btnClock.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Digital Clock is pressed");
            }
        });

        // Action for Hourglass button
        btnHourglass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                label.setText("Hour Glass is pressed");
            }
        });

        // Panel for buttons (side by side)
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnClock);
        buttonPanel.add(btnHourglass);

        // Set layout for frame (Top = buttons, Bottom = text)
        frame.setLayout(new BorderLayout());

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(label, BorderLayout.SOUTH);

        // Frame size
        frame.setSize(350, 250);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}