import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ButtonEventDemo {

    public static void main(String[] args) {

        // create JFrame
        JFrame frame = new JFrame("Button Event Handling");

        // create buttons
        JButton btnIndia = new JButton("India");
        JButton btnSrilanka = new JButton("Srilanka");

        // create label to display message
        JLabel label = new JLabel("Press any button");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 18));

        // set layout
        frame.setLayout(new FlowLayout());

        // add action listener to India button
        btnIndia.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // display message when India button is pressed
                label.setText("India is pressed");
            }
        });

        // add action listener to Srilanka button
        btnSrilanka.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                // display message when Srilanka button is pressed
                label.setText("Srilanka is pressed");
            }
        });

        // add components to frame
        frame.add(btnIndia);
        frame.add(btnSrilanka);
        frame.add(label);

        // set frame size
        frame.setSize(300, 200);

        // close program on clicking X
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make frame visible
        frame.setVisible(true);
    }
}