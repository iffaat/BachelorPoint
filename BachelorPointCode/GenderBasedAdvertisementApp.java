import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GenderBasedAdvertisementApp {
    private JFrame frame;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JButton showAdvertisementButton;
    private JLabel advertisementLabel;

    public GenderBasedAdvertisementApp() {
        // Create a new JFrame
        frame = new JFrame("Gender-Based Advertisement");

        // Create radio buttons
        maleRadioButton = new JRadioButton("Male");
        femaleRadioButton = new JRadioButton("Female");

        // Create a button group for radio buttons to ensure only one can be selected
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(maleRadioButton);
        genderButtonGroup.add(femaleRadioButton);

        // Create a button to show the advertisement
        showAdvertisementButton = new JButton("Show Advertisement");

        // Create a label to display the advertisement
        advertisementLabel = new JLabel("");

        // Set layout for the frame
        frame.setLayout(new GridLayout(4, 1));

        // Add components to the frame
        frame.add(maleRadioButton);
        frame.add(femaleRadioButton);
        frame.add(showAdvertisementButton);
        frame.add(advertisementLabel);

        // Register an ActionListener for the "Show Advertisement" button
        showAdvertisementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdvertisement();
            }
        });

        // Set default close operation and size
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void showAdvertisement() {
        if (maleRadioButton.isSelected()) {
            advertisementLabel.setText("Special Offer for Bachelor");
        } else if (femaleRadioButton.isSelected()) {
            advertisementLabel.setText("Offer for Bachelor");
        } else {
            advertisementLabel.setText("Please select your gender to view the advertisement.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GenderBasedAdvertisementApp();
            }
        });
    }
}