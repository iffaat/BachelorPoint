import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.sql.*;
import java.awt.Color;

public class bachelorMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	JLabel lblfirstNameOutput = new JLabel("");
	JLabel lbllastNameOutput = new JLabel("");
	JLabel lblnIDNumberOutput = new JLabel("");
	JLabel lblemailOutput = new JLabel("");
	JLabel lblGenderOutput = new JLabel("");
	JLabel lblAddressOutput = new JLabel("");
	JLabel lblphoneNumberOutput = new JLabel("");
	
	
	String email="";
	String password="";
	String perception="";
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
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
	
	/*public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						bachelorMenu window = new bachelorMenu(email,password,perception);
						window.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}*/
	public  void mainBachelor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bachelorMenu window = new bachelorMenu(email,password,perception);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  void mainBachelor2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bachelorMenu window = new bachelorMenu(email,perception);
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

	public bachelorMenu(String email,String password,String perception) {
		Connect();
		this.email=email;
		this.password=password;
		this.perception=perception;
		initialize();
		 lblChangeWhenUserLogsIn();
		
		
		
	}
	public bachelorMenu(String email,String perception) {
		Connect();
		this.email=email;

		this.perception=perception;
		initialize();
		 lblChangeWhenUserLogsIn2();
		
		
		
	}
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
		
		
		JLabel lblNewLabel = new JLabel("Basic Information");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblNewLabel.setBounds(56, 45, 262, 38);
		frame.getContentPane().add(lblNewLabel);

		JLabel lblfirstName = new JLabel("First Name");
		lblfirstName.setForeground(Color.WHITE);
		lblfirstName.setBounds(56, 89, 96, 31);
		frame.getContentPane().add(lblfirstName);
		lblfirstNameOutput.setForeground(Color.WHITE);

		
		lblfirstNameOutput.setBounds(142, 95, 186, 21);
		frame.getContentPane().add(lblfirstNameOutput);

		JLabel lbllastName = new JLabel("Last Name");
		lbllastName.setForeground(Color.WHITE);
		lbllastName.setBounds(56, 131, 77, 16);
		frame.getContentPane().add(lbllastName);
		lbllastNameOutput.setForeground(Color.WHITE);

		
		lbllastNameOutput.setBounds(142, 126, 176, 21);
		frame.getContentPane().add(lbllastNameOutput);

		JLabel lblphoneNumber = new JLabel("Phone Number");
		lblphoneNumber.setForeground(Color.WHITE);
		lblphoneNumber.setBounds(26, 164, 93, 16);
		frame.getContentPane().add(lblphoneNumber);
		lblphoneNumberOutput.setForeground(Color.WHITE);

	
		lblphoneNumberOutput.setBounds(142, 160, 177, 21);
		frame.getContentPane().add(lblphoneNumberOutput);

		JLabel lblnID = new JLabel("NID");
		lblnID.setForeground(Color.WHITE);
		lblnID.setBounds(83, 205, 36, 16);
		frame.getContentPane().add(lblnID);

		JLabel lblemail = new JLabel("Email");
		lblemail.setForeground(Color.WHITE);
		lblemail.setBounds(76, 237, 46, 16);
		frame.getContentPane().add(lblemail);
		lblnIDNumberOutput.setForeground(Color.WHITE);

	
		lblnIDNumberOutput.setBounds(142, 205, 186, 16);
		frame.getContentPane().add(lblnIDNumberOutput);
		lblemailOutput.setForeground(Color.WHITE);

		
		lblemailOutput.setBounds(142, 237, 208, 16);
		frame.getContentPane().add(lblemailOutput);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(56, 271, 61, 16);
		frame.getContentPane().add(lblGender);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setBounds(56, 298, 61, 16);
		frame.getContentPane().add(lblAddress);
		lblAddressOutput.setForeground(Color.WHITE);

		
		lblAddressOutput.setBounds(142, 298, 220, 16);
		frame.getContentPane().add(lblAddressOutput);
		lblGenderOutput.setForeground(Color.WHITE);
		
		
		lblGenderOutput.setBounds(142, 273, 176, 14);
		frame.getContentPane().add(lblGenderOutput);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInWindow n=new logInWindow();
				n.main();
				frame.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(1787, 964, 117, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton searchAdvertisement = new JButton("Search advertisement");
		searchAdvertisement.setBackground(Color.DARK_GRAY);
		searchAdvertisement.setForeground(Color.WHITE);
		searchAdvertisement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchAdvertisements s=new searchAdvertisements(email,password,perception);
				s.mainSearchAdvertisements();
				frame.setVisible(false);
			}
		});
		searchAdvertisement.setBounds(1728, 174, 176, 23);
		frame.getContentPane().add(searchAdvertisement);
		
		JButton btnFeedback = new JButton("Feedback");
		btnFeedback.setForeground(Color.WHITE);
		btnFeedback.setBackground(Color.DARK_GRAY);
		btnFeedback.setBounds(1767, 198, 137, 23);
		frame.getContentPane().add(btnFeedback);
		
		JButton btnEditaccount = new JButton("Edit Account");
		btnEditaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BachelorAccountEditWindow b=new BachelorAccountEditWindow(email,false,0);
				b.main();
				frame.setVisible(false);
			}
		});
		btnEditaccount.setForeground(Color.WHITE);
		btnEditaccount.setBackground(Color.DARK_GRAY);
		btnEditaccount.setBounds(1767, 223, 137, 23);
		frame.getContentPane().add(btnEditaccount);
		
		JButton btnNewButton =new JButton("Delete Account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountDelete a=new AccountDelete(email,"Bachelor");
				a.main();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(1767, 247, 137, 23);
		frame.getContentPane().add(btnNewButton);
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedBackWindow f=new feedBackWindow(email);
				f.main();
			}
		});

	}

	
	 public void lblChangeWhenUserLogsIn()
	    {
		 try {
             
             
                 pst = con.prepareStatement("select firstName,lastName,phoneNumber,nID,Gender,address from "+perception+" where email = ? AND  password_ = ?");
                 pst.setString(1, email);
                 pst.setString(2, password);
             
                 ResultSet rs = pst.executeQuery();
               
                 
               if(rs.next()==true)
             
             {    
               
                String firstName = rs.getString(1);
                 
                 String lastName = rs.getString(2);
                 
                 
                 long  phoneNumber = rs.getLong(3);
                 long  nID = rs.getLong(4);
                
                 String gender = rs.getString(5);
                 
                 String address = rs.getString(6);
                 System.out.print(firstName+" "+lastName+" "+phoneNumber+" "+nID+" "+gender+" "+address+">>>>");
                 
                 
                 lblfirstNameOutput.setText(firstName);
                 lbllastNameOutput.setText(lastName);
                 
                 String numberStr = Long.toString(phoneNumber);

                 // Calculate the number of digits
                 int digitCount = numberStr.length();
                 String zero="";
                 if(digitCount<11) {
                	// for(int i=1;i<=11-digitCount;i++) {
                		 zero=zero+"0";
                	// }
                	 lblphoneNumberOutput.setText(zero+""+phoneNumber);  
                 }
                 
                 
                 
                 //else { lblphoneNumberOutput.setText(""+phoneNumber+"");} 
                 
                 zero="";
                 lblnIDNumberOutput.setText(""+nID+"");
                  
                  
                 
                 
                 lblGenderOutput.setText(gender);
                 lblAddressOutput.setText(address);
                 
                 lblemailOutput.setText(email);
                 
            
                 
              //   if(firstName.equals("") && lastName.equals("")) {
                 	
              //   	throw new SQLException();                   	
               //  }
                 
                           
             }   
      
         } 
     
      catch (SQLException ex) {
    	  ex.printStackTrace();
         }
		 
	    }

	 public void lblChangeWhenUserLogsIn2()
	    {
		 try {
          
          
              pst = con.prepareStatement("select firstName,lastName,phoneNumber,nID,Gender,address from "+perception+" where email = ?");
              pst.setString(1, email);
         
          
              ResultSet rs = pst.executeQuery();
            
              
            if(rs.next()==true)
          
          {    
            
             String firstName = rs.getString(1);
              
              String lastName = rs.getString(2);
              
              
              long  phoneNumber = rs.getLong(3);
              long  nID = rs.getLong(4);
             
              String gender = rs.getString(5);
              
              String address = rs.getString(6);
              System.out.print(firstName+" "+lastName+" "+phoneNumber+" "+nID+" "+gender+" "+address+">>>>");
              
              
              lblfirstNameOutput.setText(firstName);
              lbllastNameOutput.setText(lastName);
              
              String numberStr = Long.toString(phoneNumber);

              // Calculate the number of digits
              int digitCount = numberStr.length();
              String zero="";
              if(digitCount<11) {
             	// for(int i=1;i<=11-digitCount;i++) {
             		 zero=zero+"0";
             	// }
             	 lblphoneNumberOutput.setText(zero+""+phoneNumber);  
              }
              
              
              
              //else { lblphoneNumberOutput.setText(""+phoneNumber+"");} 
              
              zero="";
              lblnIDNumberOutput.setText(""+nID+"");
               
               
              
              
              lblGenderOutput.setText(gender);
              lblAddressOutput.setText(address);
              
              lblemailOutput.setText(email);
              
         
              
           //   if(firstName.equals("") && lastName.equals("")) {
              	
           //   	throw new SQLException();                   	
            //  }
              
                        
          }   
   
      } 
  
   catch (SQLException ex) {
 	  ex.printStackTrace();
      }
		 
	    }
}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
