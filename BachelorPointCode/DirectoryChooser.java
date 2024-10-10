

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DirectoryChooser extends JFrame {
    
    public DirectoryChooser() {
        setTitle("Directory Chooser Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        
        JButton chooseButton = new JButton("Choose Directory");
        chooseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedDirectory = chooseDirectory();
                if (selectedDirectory != null) {
                    JOptionPane.showMessageDialog(null, "Selected Directory: " + selectedDirectory);
                } else {
                    JOptionPane.showMessageDialog(null, "Directory selection canceled.");
                }
            }
        });
        
        getContentPane().add(chooseButton);
    }

    public String chooseDirectory() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            String selectedDirectory = fileChooser.getSelectedFile().getAbsolutePath();
            return selectedDirectory;
        } else {
            return null;
        }
    }


}
