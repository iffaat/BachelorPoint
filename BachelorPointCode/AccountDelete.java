import java.awt.EventQueue;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AccountDelete {

	private JFrame frame;
   // static String email="p";
	 static String email="";
     String perception=null;
	/**
	 * Launch the application.
	 */
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bachelor point", "root", "");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountDelete window = new AccountDelete(email,perception);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	public  void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountDelete window = new AccountDelete(email,perception);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public AccountDelete(String email,String perception) {
		this.email=email;
		this.perception=perception;
		initialize();
		Connect();
	}
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(550, 230, 800, 600);
		frame.getContentPane().setLayout(null);
		
		ImageIcon backgroundImageIcon = new ImageIcon("C:/Users/bad98/OneDrive/Desktop/3607424.jpg"); 
	    JLabel backgroundLabel = new JLabel(backgroundImageIcon);
	    backgroundLabel.setBounds(0, 0, backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
	    frame.setContentPane(backgroundLabel);
		
		JButton btnNewButton = new JButton("Yes");
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		           
		            try {System.out.print("p>>>"+perception);
		                   pst = con.prepareStatement("delete from "+perception+" where email =?");
		           
		                   pst.setString(1, email);
		                   pst.executeUpdate();
		                  
		                   
		                   logInWindow m=new logInWindow();
		                   m.main();
		                   frame.setVisible(false);
		               
		               }

		               catch (SQLException e1) {
		                   
		                   e1.printStackTrace();
		               }
				
			}
		});
		btnNewButton.setBounds(285, 248, 197, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Do you really want to delete this account?");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(169, 154, 436, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBackground(Color.RED);
		lblNewLabel_1.setBounds(344, 307, 81, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNo = new JButton("No");
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("P="+perception);
				if(perception.equals("owner")) {
				ownerMenu o=new ownerMenu(email);
				o.mainOwner2();
				frame.setVisible(false);
			}
				if(perception.equals("Bachelor")) {bachelorMenu o=new bachelorMenu(email,"bachelor");  //Big B for bachelor
				o.mainBachelor2();
				frame.setVisible(false);
			}
			
			
			}
		});
		btnNo.setForeground(Color.WHITE);
		btnNo.setBackground(Color.DARK_GRAY);
		btnNo.setBounds(285, 273, 197, 23);
		frame.getContentPane().add(btnNo);
	}
}
