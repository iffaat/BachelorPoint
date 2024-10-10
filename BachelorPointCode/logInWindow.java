import java.awt.EventQueue;
import javax.imageio.ImageIO;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import java.awt.EventQueue;
import java.awt.Color;
public class logInWindow {

	private JFrame frame;
	private JTextField textEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
    private static JPasswordField passwordField;
    private static JLabel errorLabel;

	/**
	 * Launch the application.
	 */
    String firstName="";
    String lastName="";
    String perception="";
    String email="";
    String password="";
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    private JPasswordField textPassword;
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
    
    
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logInWindow window = new logInWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
    
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logInWindow window = new logInWindow();
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
	public logInWindow() {
		perception="";
		Connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.setBounds(100, 100, 733, 507);
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon backgroundImageIcon = new ImageIcon("C:/Users/bad98/OneDrive/Desktop/3607424.jpg"); 
	    JLabel backgroundLabel = new JLabel(backgroundImageIcon);
	    backgroundLabel.setBounds(0, 0, backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
	    frame.setContentPane(backgroundLabel);
		textEmail = new JTextField();
		textEmail.setBounds(809, 418, 299, 20);
		frame.getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(755, 417, 65, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(743, 447, 65, 19);
		frame.getContentPane().add(lblPassword);
		
		JRadioButton rdbtnBachelor = new JRadioButton("Bachelor");
		rdbtnBachelor.setBackground(new Color(0, 0, 0));
		rdbtnBachelor.setForeground(Color.WHITE);
		rdbtnBachelor.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				perception=rdbtnBachelor.getText();
				
			System.out.print( rdbtnBachelor.getText());
			
			}
		});
		buttonGroup.add(rdbtnBachelor);
		rdbtnBachelor.setBounds(1018, 475, 90, 23);
		frame.getContentPane().add(rdbtnBachelor);
		
		
		JRadioButton rdbtnOwner = new JRadioButton("Owner");
		rdbtnOwner.setBackground(new Color(0, 0, 0));
		rdbtnOwner.setForeground(Color.WHITE);
		rdbtnOwner.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				perception=rdbtnOwner.getText();
				
				System.out.print( rdbtnOwner.getText());
			}
			
		});
		buttonGroup.add(rdbtnOwner);
		rdbtnOwner.setBounds(809, 475, 72, 23);
		frame.getContentPane().add(rdbtnOwner);
		

		JLabel lblMsg = new JLabel("");
		lblMsg.setForeground(new Color(255, 0, 0));
		lblMsg.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton logInButton = new JButton("log In");
		logInButton.setBackground(new Color(128, 0, 128));
		logInButton.setForeground(Color.WHITE);
		logInButton.addActionListener(new ActionListener() {
			
			//*******Login********
			public  void actionPerformed(ActionEvent e) {
				
				try {
                    
                     email = textEmail.getText();
                     password = textPassword.getText();
                    System.out.print("Password101");
                        pst = con.prepareStatement("select 	firstName,lastName from "+perception+" where email = ? AND  password_ = ?");
                        pst.setString(1, email);
                        pst.setString(2, password);
                        System.out.print(perception);
                        System.out.print(email);
                        System.out.print(password);
                        ResultSet rs = pst.executeQuery();
                      
                        
                      if(rs.next()==true)
                    
                    {   
                      
                        firstName = rs.getString(1);
                        
                        lastName = rs.getString(2);
                        
                       System.out.print("here>>>****"+ rs.getString(1)+"*****<<<here");
                    
                     if(perception.equals("Owner")==true) {  
                       ownerMenu w = new ownerMenu(email,password,perception);
                        w.mainOwner();
            			frame.setVisible(false);
                    }
                     if(perception.equals("Bachelor")==true) {  
                         bachelorMenu w = new bachelorMenu(email,password,perception);
                         w.mainBachelor();
             			frame.setVisible(false);
                     }
                    
                   
                                  
                    }   
                    else
                    { throw new SQLException(); 
                    	
                    
                        
                    }
                } 
            
             catch (SQLException ex) {
            		ex.printStackTrace();
		           
		        	 if(perception.equals("")||email.equals("")||password.equals("")) {
			    	
			    		lblMsg.setText("Incomplete Email,password or perceoption !");
		        	 }
		        	 else {
		        		 lblMsg.setText("No account found!");
		        	 }
			    	
	
                }
				  
			}
		});
		logInButton.setBounds(907, 531, 89, 23);
		frame.getContentPane().add(logInButton);
		
		JLabel lblNewLabel_1 = new JLabel("Don't have an account? Create a  new one!");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(809, 565, 284, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnCreateAnNew = new JButton("Create a new account");
		btnCreateAnNew.setBackground(new Color(128, 0, 128));
		btnCreateAnNew.setForeground(Color.WHITE);
		btnCreateAnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewAccountChoosePerception n=new CreateNewAccountChoosePerception();
				n.main();
				frame.setVisible(false);
				
			}
		});
		btnCreateAnNew.setBounds(868, 596, 173, 23);
		frame.getContentPane().add(btnCreateAnNew);
		
		
		lblMsg.setBounds(776, 630, 372, 16);
		frame.getContentPane().add(lblMsg);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(809, 449, 299, 20);
		frame.getContentPane().add(textPassword);

	}
}
