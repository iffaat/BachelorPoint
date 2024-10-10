import java.awt.EventQueue;
import javax.swing.border.LineBorder;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
public class CreateNewAccountChoosePerception {
	int count90=1;
    String perception="";
    Blob g;
    String gender="";
    JButton btnAddPictures = new JButton("add profile picture");
    String address=null;
    private static int v;
	private JFrame frame;
	private JTextField textFirstName;
	private JTextField textNID;
	private JTextField textEmail;
	private JTextField textPassword;
	JButton btnNewButton = new JButton("Undone");
	private JTextField textLastName;
	private JTextField textPhoneNumber;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textAddress;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JLabel lblMsg = new JLabel("");
	JLabel lblProfileImage = new JLabel("");

	/**
	 * Launch the application.
	 */
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	Connection con2;
	PreparedStatement pst2;
	ResultSet rs2;

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
	
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewAccountChoosePerception window = new CreateNewAccountChoosePerception();
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
	public CreateNewAccountChoosePerception() {
		Connect();
		Connect2();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private  BufferedImage toBufferedImage(Image img) {
	    if (img instanceof BufferedImage) {
	        return (BufferedImage) img;
	    }

	    BufferedImage bufferedImage = new BufferedImage(
	        img.getWidth(null),
	        img.getHeight(null),
	        BufferedImage.TYPE_INT_ARGB
	    );

	    bufferedImage.getGraphics().drawImage(img, 0, 0, null);
	    return bufferedImage;
	}
	public  Blob imageToBlob(Image img) throws SQLException, IOException {
	    if (img == null) {
	        throw new IllegalArgumentException("Input Image is null");
	    }

	    // Convert the Image to a BufferedImage (if not already)
	    BufferedImage bufferedImage = toBufferedImage(img);

	    // Convert BufferedImage to byte array
	    byte[] imageBytes = toByteArray(bufferedImage);

	    // Create a Blob object from the byte array
	    Blob imageBlob = new SerialBlob(imageBytes);

	    return imageBlob;
	}
	private static byte[] toByteArray(BufferedImage img) throws IOException {
	    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	    ImageIO.write(img, "png", outputStream);
	    return outputStream.toByteArray();
	}
	public  Image loadImage(String imagePath) throws IOException {
	    File imageFile = new File(imagePath);

	    if (!imageFile.exists()) {
	        throw new IOException("Image file does not exist: " + imagePath);
	    }

	    BufferedImage bufferedImage = ImageIO.read(imageFile);

	    if (bufferedImage == null) {
	        throw new IOException("Failed to read the image: " + imagePath);
	    }

	    return bufferedImage;
	}
	public static String chooseDirectory() {
	    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

	    int returnValue = fileChooser.showOpenDialog(null);
	    if (returnValue == JFileChooser.APPROVE_OPTION) {
	        return fileChooser.getSelectedFile().getAbsolutePath();
	    } else {
	        return null; // User canceled the dialog or an error occurred
	    }
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
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblFirstName.setBounds(40, 222, 65, 28);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblNID = new JLabel("NID");
		lblNID.setForeground(Color.WHITE);
		lblNID.setHorizontalAlignment(SwingConstants.CENTER);
		lblNID.setBounds(51, 315, 65, 28);
		frame.getContentPane().add(lblNID);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(51, 342, 65, 28);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(51, 369, 65, 28);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(51, 397, 65, 28);
		frame.getContentPane().add(lblGender);
		
		textFirstName = new JTextField("");
		textFirstName.setBackground(Color.GRAY);
		textFirstName.setForeground(Color.WHITE);
		textFirstName.setBounds(126, 226, 146, 20);
		frame.getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		textNID = new JTextField("");
		textNID.setForeground(Color.WHITE);
		textNID.setBackground(Color.GRAY);
		textNID.setColumns(10);
		textNID.setBounds(126, 319, 197, 20);
		frame.getContentPane().add(textNID);
		
		textEmail = new JTextField("");
		textEmail.setForeground(Color.WHITE);
		textEmail.setBackground(Color.GRAY);
		textEmail.setColumns(10);
		textEmail.setBounds(126, 346, 197, 20);
		frame.getContentPane().add(textEmail);
		
		textPassword = new JTextField("");
		textPassword.setForeground(Color.WHITE);
		textPassword.setBackground(Color.GRAY);
		textPassword.setColumns(10);
		textPassword.setBounds(126, 373, 197, 20);
		frame.getContentPane().add(textPassword);
		
		
		//btnNewButton.setBounds(512, 375, 89, 23);
		//frame.getContentPane().add(btnNewButton);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setBounds(40, 249, 65, 28);
		frame.getContentPane().add(lblLastName);
		
		textLastName = new JTextField("");
		textLastName.setForeground(Color.WHITE);
		textLastName.setBackground(Color.GRAY);
		textLastName.setColumns(10);
		textLastName.setBounds(126, 257, 146, 20);
		frame.getContentPane().add(textLastName);
		
		textPhoneNumber = new JTextField("");
		textPhoneNumber.setForeground(Color.WHITE);
		textPhoneNumber.setBackground(Color.GRAY);
		textPhoneNumber.setColumns(10);
		textPhoneNumber.setBounds(126, 288, 136, 20);
		frame.getContentPane().add(textPhoneNumber);
		
		JLabel lblPhoneNumber = new JLabel(" Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setBounds(27, 284, 96, 28);
		frame.getContentPane().add(lblPhoneNumber);
		
		JRadioButton rdbtnNewRadioButtonMale = new JRadioButton("Male");
		rdbtnNewRadioButtonMale.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButtonMale.setForeground(Color.WHITE);
		rdbtnNewRadioButtonMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender=rdbtnNewRadioButtonMale.getText();
			}
		});
		buttonGroup.add(rdbtnNewRadioButtonMale);
		rdbtnNewRadioButtonMale.setBounds(126, 400, 57, 23);
		frame.getContentPane().add(rdbtnNewRadioButtonMale);
		
		JRadioButton rdbtnNewRadioButtonFemale = new JRadioButton("Female");
		rdbtnNewRadioButtonFemale.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButtonFemale.setForeground(Color.WHITE);
		rdbtnNewRadioButtonFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender=rdbtnNewRadioButtonFemale.getText();
			}
		});
		buttonGroup.add(rdbtnNewRadioButtonFemale);
		rdbtnNewRadioButtonFemale.setBounds(185, 400, 65, 23);
		frame.getContentPane().add(rdbtnNewRadioButtonFemale);
		
		JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Others");
		rdbtnNewRadioButton_1_1_1.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButton_1_1_1.setForeground(Color.WHITE);
		rdbtnNewRadioButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender=rdbtnNewRadioButton_1_1_1.getText();
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1_1_1);
		rdbtnNewRadioButton_1_1_1.setBounds(252, 400, 65, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1_1_1);
		
		textAddress = new JTextField("");
		textAddress.setForeground(Color.WHITE);
		textAddress.setBackground(Color.GRAY);
		textAddress.setColumns(10);
		textAddress.setBounds(126, 430, 197, 20);
		frame.getContentPane().add(textAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(51, 426, 65, 28);
		frame.getContentPane().add(lblAddress);
		btnAddPictures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 lblProfileImage.setText("No Photos");;
				address=chooseDirectory();
				System.out.println("address>>"+address+"<<");
				if(address==null) {
					g=null;
					lblProfileImage.setVisible(true);
					lblProfileImage.setIcon(null);
					lblProfileImage.setText("No Photos");;
					
				}
				else {
				try{
					 g=imageToBlob(loadImage(address));
					
					

				
					
				}catch(Exception e1) {
					
					e1.printStackTrace();
				}
			
			
//
				lblProfileImage.setVisible(false);
				try {
			
			
			if( imageToBlob(loadImage(address))!=null) {
				System.out.print("here is b"+imageToBlob(loadImage(address)));
				Image img = ImageIO.read(g.getBinaryStream());
			if(img==null) {
					 lblProfileImage.setIcon(null);
					lblProfileImage.setText("No Profile Picture!");
					 lblProfileImage.setVisible(true);
					
				}	
				else{ 
					System.out.print("535");
				   img = ImageIO.read(g.getBinaryStream()).getScaledInstance(400, 400, Image.SCALE_SMOOTH);
		           ImageIcon icon = new ImageIcon(img);
		           lblProfileImage.setVisible(true);
		           lblProfileImage.setIcon(icon);
				}
			}
			if(g==null) {
				 lblProfileImage.setIcon(null);
					lblProfileImage.setText("No Profile Picture!");
					 lblProfileImage.setVisible(true);
			}
			}catch(Exception e1) {
					e1.printStackTrace();				
					}
				}
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			}
		});
	
		
		btnAddPictures.setVisible(false);
		btnAddPictures.setBounds(295, 11, 159, 23);
		frame.getContentPane().add(btnAddPictures);
		
	
		
		
		JRadioButton rdbtnNewRadioButtonPerception = new JRadioButton("Bachelor");
		rdbtnNewRadioButtonPerception.setBackground(Color.LIGHT_GRAY);
		rdbtnNewRadioButtonPerception.setForeground(Color.WHITE);
		rdbtnNewRadioButtonPerception.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			//radioButtonBachelor
				g=null;
				perception=rdbtnNewRadioButtonPerception.getText();			
				
				System.out.print(perception);
				btnAddPictures.setVisible(false);
				 btnNewButton.setVisible(false);
				 lblProfileImage.setVisible(false);
				 address=null;
				
			}
		});
		
		
		buttonGroup_1.add(rdbtnNewRadioButtonPerception);
		rdbtnNewRadioButtonPerception.setBounds(454, 426, 82, 23);
		frame.getContentPane().add(rdbtnNewRadioButtonPerception);
		
		JRadioButton rdbtnOwner = new JRadioButton("Owner");
		rdbtnOwner.setForeground(Color.WHITE);
		rdbtnOwner.setBackground(Color.LIGHT_GRAY);
		//int count90=1;
		
		//here
		rdbtnOwner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblProfileImage.setVisible(true);
				LineBorder border = new LineBorder(Color.BLUE, 2);

		        // Set the border for the label
				lblProfileImage.setBorder(border);
			g=null;
				perception=rdbtnOwner.getText();
				System.out.print(perception);
			//if(isOdd(count90)) {
				//JButton btnAddPictures = new JButton("add profile picture");
             count90=count90+1;
				btnAddPictures.setVisible(true);
		//	}	
			//else {
				//btnAddPictures.setVisible(false);
			//}
				
				 lblProfileImage .setText("No Photos");
				 btnNewButton.setVisible(true);
			
			}
		});
		
		System.out.print("gg"+perception);
		
		buttonGroup_1.add(rdbtnOwner);
		rdbtnOwner.setBounds(549, 426, 82, 23);
		frame.getContentPane().add(rdbtnOwner);
		lblMsg.setForeground(Color.WHITE);
	
		
		lblMsg.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMsg.setBounds(1325, 972, 308, 28);
		frame.getContentPane().add(lblMsg);
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				logInWindow n=new logInWindow();
				n.main();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(1748, 977, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Create");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(Color.DARK_GRAY);
		
		 System.out.print("gender="+gender);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				//createAccount
    			    String firstName = textFirstName.getText();
				    String lastName = textLastName.getText();
				    String phoneNumber=textPhoneNumber.getText(); 
				    String nID=textNID.getText(); 
				    String email=textEmail.getText();
				    String password_=textPassword.getText();
				    String gender_=gender;
				    String address=textAddress.getText();
			
                
					  lblMsg.setForeground(Color.RED);
			   
				
				     try {
				    	 
				    	 if(firstName.equals("")|| lastName.equals("")||phoneNumber.equals("")|| nID.equals("")|| email.equals("")|| password_.equals("")|| password_.equals("")|| gender_.equals("")|| address.equals(""))
				    	 {throw  new SQLException();}
				    	 if(CheckNID (nID,13)==false) {throw  new SQLException();}
				    	 if(CheckPhoneNumber (phoneNumber,11)==false) {throw  new SQLException();}
				    	
				    	 
				    	 if(perception.equals("Owner")) {
				    		 
				        pst = con.prepareStatement("insert into "+perception+"(firstName,lastName,phoneNumber,nID,email,password_,gender,address,img1)values(?,?,?,?,?,?,?,?,?)");
				        pst.setString(1, firstName);
				        pst.setString(2, lastName);
				        pst.setString(3, phoneNumber);
				        pst.setString(4, nID);
				        pst.setString(5, email);
				        pst.setString(6, password_);
				        pst.setString(7, gender_);
				        pst.setString(8, address);
				        pst.setBlob(9, g);
				        pst.executeUpdate();
				                       
				        lblMsg.setText("Account Has been created!");
				        lblMsg.setForeground(Color.GREEN);
				      
				    	 
				    	 }
				    	 
				    	 if(perception.equals("Bachelor")) {
						        pst = con.prepareStatement("insert into "+perception+"(firstName,lastName,phoneNumber,nID,email,password_,gender,address)values(?,?,?,?,?,?,?,?)");
						        pst.setString(1, firstName);
						        pst.setString(2, lastName);
						        pst.setString(3, phoneNumber);
						        pst.setString(4, nID);
						        pst.setString(5, email);
						        pst.setString(6, password_);
						        pst.setString(7, gender_);
						        pst.setString(8, address);
						       
						        pst.executeUpdate();
						                       
						        lblMsg.setText("Account Has been created!");
						        lblMsg.setForeground(Color.GREEN);}
			
				       
				      
				       }
				    catch (SQLException e1) 
				            {
				    	
				    	System.out.print("error="+e1.getErrorCode());
				    	
				    	
				    	if (e1.getErrorCode() == 1062) {
		                    System.out.println("Duplicate entry detected.");
		                    lblMsg.setForeground(Color.RED);
		                    lblMsg.setText("Another account exists with this email or nid");
		                    
		                }
				    	else {
				    		e1.printStackTrace();
				    		lblMsg.setText("Incomplete or Invalid information");
							  lblMsg.setForeground(Color.RED);
				    
				    	}
				    	
				            
				    	
				            }
				     
				   
				    
				        }
	
			   
			
		}); 	
				
		btnNewButton_1_1.setBounds(1649, 977, 89, 23);
		frame.getContentPane().add(btnNewButton_1_1);
		
		JLabel lblNewLabel = new JLabel("13 digit");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(331, 322, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDigit = new JLabel("11 digit");
		lblDigit.setForeground(Color.RED);
		lblDigit.setBounds(272, 291, 74, 14);
		frame.getContentPane().add(lblDigit);
		lblProfileImage.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProfileImage.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		lblProfileImage.setBounds(39, 1, 246, 210);
		frame.getContentPane().add(lblProfileImage);
		
		
		
		btnNewButton.setVisible(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LineBorder border = new LineBorder(Color.BLUE, 2);

		        // Set the border for the label
				lblProfileImage.setBorder(border);
				g=null;
				address=null;
				lblProfileImage.setVisible(true);
				lblProfileImage.setIcon(null);
				lblProfileImage.setText("No Photos");;
			
			
			}
		});
		btnNewButton.setBounds(295, 45, 159, 23);
		frame.getContentPane().add(btnNewButton);
		
	/*	JButton btnAddPictures = new JButton("add profile picture");
		btnAddPictures.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			address=chooseDirectory();
			try{
				 g=imageToBlob(loadImage(address));
				
				

			
				
			}catch(Exception e1) {
				
				e1.printStackTrace();
			}
			}
		});
	*/	
	
		//frame.getContentPane().add(btnAddPictures);
		
		
	}

	  public static int charToInt(char character) {
	        return (int) character;
	    }
	

public static boolean CheckPhoneNumber (String s,int limit) {
	
	   if(s.charAt(0)!='0'&& s.charAt(1)!='1') {
	    	return false;
		  }
	   
     int x;
    
     int count=0;
     for(int i=0;i<s.length();i++) { 
    	 
  	   
  	  x=charToInt(s.charAt(i));
  	  
  	  
  	  
  	  if(x>=48 && x<=57 && count<=limit) {
  		  
  		  count=count+1;
  		  System.out.print(s.charAt(i));
		 
  	  }
  	  else{break;}  	  
     }
     if (count==limit) {
    	 System.out.print(true);  return true;
     }
     else {
    	 System.out.print(false); return false;
     }
       
		
	}



public static boolean CheckNID (String s,int limit) {
	   
    int x;
   
    int count=0;
    
    if(s.charAt(0)=='0') {
    	return false;
	  }
    
    
    for(int i=0;i<s.length();i++) { 
 	   
 	  x=charToInt(s.charAt(i));
 	
 	  
 	  if(x>=48 && x<=57 && count<=limit) {
 		  
 		  count=count+1;
 		  System.out.print(s.charAt(i));
 		 
 	  }
 	  else{break;}
 	  
    }
    
    
 //switch(count) {  
// case 13 : System.out.print(true);  return true;
// case 11:  System.out.print(true);  return true;
// default:  System.out.print(false); return false;
 
// }
    if (count==limit) {
   	 System.out.print(true);  return true;
    }
    else {
   	 System.out.print(false); return false;
    }
      
		
	}
public static boolean isOdd(int number) {
    return number % 2 != 0;
}
}

