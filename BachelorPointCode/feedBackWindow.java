import java.awt.Color;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class feedBackWindow {
    static String email="";
	String msg="";
    JLabel lblMsg = new JLabel("");
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	Connection con2;
	PreparedStatement pst2;
	ResultSet rs2;
	PreparedStatement pst;
	ResultSet rs;
	Connection con;
	 public void Connect()
	    {
	        try {
	        	
	            Class.forName("com.mysql.jdbc.Driver");
	        
	            con = DriverManager.getConnection("jdbc:mysql://localhost/bachelor point", "root","");
	      
	        }
	        catch (ClassNotFoundException ex) 
	        { 
	          ex.printStackTrace();
	         
	        }
	        catch (SQLException ex) 
	        {
	               ex.printStackTrace();
	        }
	    }
	 public void Connect2()
	    {
	        try {
	        	
	            Class.forName("com.mysql.jdbc.Driver");
	        
	            con2 = DriverManager.getConnection("jdbc:mysql://localhost/bachelor point", "root","");
	      
	        }
	        catch (ClassNotFoundException ex) 
	        { 
	          ex.printStackTrace();
	         
	        }
	        catch (SQLException ex) 
	        {
	               ex.printStackTrace();
	        }
	    }
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedBackWindow window = new feedBackWindow( email);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedBackWindow window = new feedBackWindow( email);
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
/*	public feedBackWindow() {
		Connect();
		initialize();
	}*/
	public feedBackWindow(String email) {
		this.email=email;
		
		Connect();
		Connect2();
		initialize();
		
	}
	public void f() {ImageIcon backgroundImageIcon = new ImageIcon("C:/Users/bad98/OneDrive/Desktop/3607424.jpg"); 
	 JLabel backgroundLabel = new JLabel(backgroundImageIcon);
	 backgroundLabel.setBounds(0, 0, backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
   frame.setContentPane(backgroundLabel);	
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(450, 200, 1027, 621);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	 
		f();
		 TextArea textDescription = new TextArea();
		 textDescription.setBackground(Color.DARK_GRAY);
		 textDescription.setForeground(Color.WHITE);
		 textDescription.setBounds(40, 58, 914, 401);
		 textDescription.setVisible(true);
		 frame.getContentPane().add(textDescription);
		 
		 JLabel lblNewLabel = new JLabel("Enter you feedback");
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setBounds(40, 29, 115, 14);
		 frame.getContentPane().add(lblNewLabel);
		 
		 JButton btnNewButton = new JButton("Send");
		 btnNewButton.setBackground(Color.DARK_GRAY);
		 btnNewButton.setForeground(Color.WHITE);
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 		msg=textDescription.getText();
		 
		 		
		 		int count=0;
			
		 		int count2=0;
		 		try {
		 			 if(msg.equals("")||msg.equals(null)) {
		 				 
		 				 count2=1;
		 				 throw new IllegalArgumentException();
		 				 
		 			 }	
		 			 
		 			 for(int i=0;i<msg.length();i++) {
		 				 if(msg.charAt(0)==' ') {
		 					count=count+1;
		 				 }
		 			 }
		 			 System.out.print(count);
		 			 System.out.println(msg.length());
		 			 if(count==(msg.length())){
		 				count2=1;
		 				 throw new IllegalArgumentException();
		 				 
		 			 }
		 			 
					 pst = con.prepareStatement("insert into feedback(email,msg)values(?,?)");
				        pst.setString(1,email);
				        pst.setString(2,msg);
				        
				        pst.executeUpdate();
				        lblMsg.setText("Sent");
				}catch(Exception e1) {
					e1.printStackTrace();
					
					//lblMsg.setText("This feedback has already been sent!\n ");
					if(count2==1) {
						lblMsg.setText("empty message!");
					}
					else {
						lblMsg.setText("This feedback has already been sent");
					}
					
					
					
					
				}
		 	}
		 	
		 	
		 	
		 	
		 	
		 	
		 	
		 });
		 
		 btnNewButton.setBounds(865, 487, 89, 23);
		 frame.getContentPane().add(btnNewButton);
		 lblMsg.setForeground(Color.WHITE);
		 
		 
		 lblMsg.setBounds(552, 491, 303, 19);
		 frame.getContentPane().add(lblMsg);
		 
	
		 
		 
		 
		 
	}
}
