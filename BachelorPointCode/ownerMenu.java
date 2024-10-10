import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.sql.*;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ownerMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */static boolean errorCheck=false;
	JLabel lblfirstNameOutput = new JLabel("");
	JLabel lbllastNameOutput = new JLabel("");
	JLabel lblnIDNumberOutput = new JLabel("");
	JLabel lblemailOutput = new JLabel("");
	JLabel lblGenderOutput = new JLabel("");
	JLabel lblAddressOutput = new JLabel("");
	JLabel lblphoneNumberOutput = new JLabel("");
	Blob b = null;
	JLabel lblProfileImage = new JLabel("");
	String email="";
	String password="";
	String perception="";
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	long pNumber=0;
	Connection con2;
	PreparedStatement pst2;
	ResultSet rs2;
	Connection con3;
	PreparedStatement pst3;
	ResultSet rs3;
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
	 public void Connect3()
	    {
	        try {
	        	
	            Class.forName("com.mysql.jdbc.Driver");
	        
	            con3 = DriverManager.getConnection("jdbc:mysql://localhost/bachelor point", "root","");
	          
	      
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
	        EventQueue.invokeLater(() -> {
	            searchAdvertisements window = new searchAdvertisements();
	            window.frame.setVisible(true);
	        });
	    }
	public  void mainOwner() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ownerMenu window = new ownerMenu(email,password,perception);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  void mainOwner2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ownerMenu window = new ownerMenu(email);
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

	public ownerMenu(String email,String password,String perception) {
		Connect();
		Connect3();
		this.email=email;
		this.password=password;
		this.perception=perception;
		initialize();
		 lblChangeWhenUserLogsIn();
		 profileImageShow();
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public ownerMenu(String email) {
		Connect2();
		Connect3();
		this.email=email;
	
		initialize();
		lblChangeWhenUserLogsIn2();	
		profileImageShow();
	}
	private void initialize() {
		frame = new JFrame();
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
		lblfirstName.setBounds(21, 335, 72, 21);
		frame.getContentPane().add(lblfirstName);
		lblfirstNameOutput.setForeground(Color.WHITE);

		
		lblfirstNameOutput.setBounds(128, 335, 186, 21);
		frame.getContentPane().add(lblfirstNameOutput);

		JButton btnNewButton = new JButton("Add Advertisements");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.DARK_GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("Email=="+email);
				addAdvertisements a=new addAdvertisements(email);
 				a.main();
 				frame.setVisible(false);
 			
			}
		});
		btnNewButton.setBounds(1738, 90, 156, 29);
		frame.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Edit Advertisements");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
               SelectMyAdvertisement s=new SelectMyAdvertisement(email);
               System.out.println("Email=="+email);
          s.mainShowMyAdvertisements();
            frame.setVisible(false);
                         
			}
		});
		btnNewButton_1.setBounds(1738, 118, 156, 29);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Delete Advertisement");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.DARK_GRAY);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			DeleteMyAdvertisements s=new DeleteMyAdvertisements(email);
	               System.out.println("Email=="+email);
	          s.mainShowMyAdvertisements();
	            frame.setVisible(false);
				
				
			}
		});
		btnNewButton_2.setBounds(1674, 147, 220, 29);
		frame.getContentPane().add(btnNewButton_2);

		JLabel lbllastName = new JLabel("Last Name");
		lbllastName.setForeground(Color.WHITE);
		lbllastName.setBounds(21, 365, 77, 16);
		frame.getContentPane().add(lbllastName);
		lbllastNameOutput.setForeground(Color.WHITE);

		
		lbllastNameOutput.setBounds(128, 360, 176, 21);
		frame.getContentPane().add(lbllastNameOutput);

		JLabel lblphoneNumber = new JLabel("Phone Number");
		lblphoneNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblphoneNumber.setForeground(Color.WHITE);
		lblphoneNumber.setBounds(5, 392, 103, 16);
		frame.getContentPane().add(lblphoneNumber);
		lblphoneNumberOutput.setForeground(Color.WHITE);

	
		lblphoneNumberOutput.setBounds(128, 387, 177, 21);
		frame.getContentPane().add(lblphoneNumberOutput);

		JLabel lblnID = new JLabel("NID");
		lblnID.setHorizontalAlignment(SwingConstants.TRAILING);
		lblnID.setForeground(Color.WHITE);
		lblnID.setBounds(36, 419, 32, 16);
		frame.getContentPane().add(lblnID);

		JLabel lblemail = new JLabel("Email");
		lblemail.setForeground(Color.WHITE);
		lblemail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblemail.setBounds(-4, 446, 72, 16);
		frame.getContentPane().add(lblemail);
		lblnIDNumberOutput.setForeground(Color.WHITE);

	
		lblnIDNumberOutput.setBounds(128, 419, 186, 16);
		frame.getContentPane().add(lblnIDNumberOutput);
		lblemailOutput.setForeground(Color.WHITE);

		
		lblemailOutput.setBounds(128, 446, 208, 16);
		frame.getContentPane().add(lblemailOutput);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setBounds(-4, 468, 72, 16);
		frame.getContentPane().add(lblGender);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(7, 495, 61, 16);
		frame.getContentPane().add(lblAddress);
		lblAddressOutput.setForeground(Color.WHITE);

		
		lblAddressOutput.setBounds(128, 495, 220, 16);
		frame.getContentPane().add(lblAddressOutput);

		JButton btnViewPostedAdvertisements = new JButton("View Posted Advertisements");
		btnViewPostedAdvertisements.setForeground(Color.WHITE);
		btnViewPostedAdvertisements.setBackground(Color.DARK_GRAY);
		btnViewPostedAdvertisements.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showMyAdvertisements s=new showMyAdvertisements(email);
				s.mainShowMyAdvertisements();
				frame.setVisible(false);
			}
		});
		btnViewPostedAdvertisements.setBounds(1674, 176, 220, 29);
		frame.getContentPane().add(btnViewPostedAdvertisements);
		lblGenderOutput.setForeground(Color.WHITE);
		
		
		lblGenderOutput.setBounds(128, 470, 176, 14);
		frame.getContentPane().add(lblGenderOutput);
		
		JButton btnNewButton_4 = new JButton("Log Out");
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBackground(Color.DARK_GRAY);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logInWindow n=new logInWindow();
				n.main();
				frame.setVisible(false);
			}
		});
		btnNewButton_4.setBounds(1777, 967, 117, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnFeedBack = new JButton("send feedback");
		btnFeedBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				feedBackWindow f=new feedBackWindow(email);
				f.main();
				
				
				
			}
		});
		btnFeedBack.setForeground(Color.WHITE);
		btnFeedBack.setBackground(Color.DARK_GRAY);
		btnFeedBack.setBounds(1674, 202, 220, 29);
		frame.getContentPane().add(btnFeedBack);
		
	
		lblProfileImage.setBounds(20, 90, 298, 237);
		frame.getContentPane().add(lblProfileImage);
		
		JButton btnAcountEdit = new JButton("Edit Account");
		btnAcountEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ownerAccountEditWindow s=new ownerAccountEditWindow(email,false,0);
				s.main();
				frame.setVisible(false);
				
			}
		});
		btnAcountEdit.setForeground(Color.WHITE);
		btnAcountEdit.setBackground(Color.DARK_GRAY);
		btnAcountEdit.setBounds(1674, 229, 220, 29);
		frame.getContentPane().add(btnAcountEdit);
		
		JButton btnNewButton_3 = new JButton("Delete Account");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AccountDelete n=new AccountDelete(email,"owner");
				n.main();
				frame.setVisible(false);
			}
		});
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBounds(1674, 257, 220, 29);
		frame.getContentPane().add(btnNewButton_3);
	}

	 public void lblChangeWhenUserLogsIn2()
	    {
		 try {
       
       
           pst2 = con2.prepareStatement("select firstName,lastName,phoneNumber,nID,Gender,address from owner where email = ?");
           pst2.setString(1, email);
    
           ResultSet rs2 = pst2.executeQuery();
         
           
         if(rs2.next()==true)
       
       {    System.out.println("hello101");
         
          String firstName = rs2.getString(1);
           
           String lastName = rs2.getString(2);
           
           System.out.print(firstName);
           long  phoneNumber = rs2.getLong(3);
         //  pNumber=phoneNumber;
           long  nID = rs2.getLong(4);
          
           String gender = rs2.getString(5);
           
           String address = rs2.getString(6);
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
	 public void lblChangeWhenUserLogsIn()
	    {
		 try {
             
             
                 pst = con.prepareStatement("select firstName,lastName,phoneNumber,nID,Gender,address from "+perception+" where email = ? AND  password_ = ?");
                 
                 
                 pst.setString(1, email);
                 pst.setString(2, password);
                 
                 System.out.print(perception);
                 System.out.print(email);
                 System.out.print(password);
                 ResultSet rs = pst.executeQuery();
               
                 
               if(rs.next()==true)
             
             {    
               
                String firstName = rs.getString(1);
                 
                 String lastName = rs.getString(2);
                 
                 System.out.print(firstName);
                 long  phoneNumber = rs.getLong(3);
               //  pNumber=phoneNumber;
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



	 public void profileImageShow()
	    {
	    try {
	    	
		    pst3 = con3.prepareStatement("select img1 from owner where email = ?");
            
            
            pst3.setString(1, email);
          
            rs3 = pst3.executeQuery();
            if(rs3.next()==true)
          
          {   
            
            b=rs3.getBlob(1);
            
            Image img = ImageIO.read(b.getBinaryStream()).getScaledInstance(400, 400, Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(img);
            lblProfileImage.setIcon(icon);
          }
            
            
            
            
            
	    }catch(Exception e1) {
	    	e1.printStackTrace();
	    }
		 
		 
		 
	    }
}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
