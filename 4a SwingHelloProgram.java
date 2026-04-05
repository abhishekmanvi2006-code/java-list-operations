import javax.swing.*;
import java.awt.*;

public class SwingHelloProgram {

    public static void main(String[] args) {

        // create JFrame object
        JFrame frame = new JFrame("Swing Hello Program");

        // create JLabel with required message
        JLabel label = new JLabel("Hello! VI C , Welcome to Swing Programming");

        // set font: Plain style with size 32
        label.setFont(new Font("Arial", Font.PLAIN, 32));

        // set text color to Blue
        label.setForeground(Color.BLUE);

        // align text to center
        label.setHorizontalAlignment(JLabel.CENTER);

        // add label to frame
        frame.add(label);

        // set size of frame window
        frame.setSize(700, 200);

        // close operation when clicking X button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // make frame visible
        frame.setVisible(true);
    }
}