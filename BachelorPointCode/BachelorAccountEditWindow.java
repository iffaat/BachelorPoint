import java.awt.EventQueue;
import java.awt.Image;
import java.math.BigInteger;
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
public class BachelorAccountEditWindow {
	 static String email="f"; //
	int count90=1;
    String perception="";
    Blob g;
    boolean removeProfilePicture=false;
    String gender="";
    String address=null;static int count159=0;
    private static int v;
	private 	JFrame frame = new JFrame();
	Blob b=null;static boolean errorCheck=false;
	private JTextField textFirstName;
	private JTextField textNID;
	private JTextField textLastName;
	private JTextField textPhoneNumber;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textAddress;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	JLabel lblMsg = new JLabel("");
	JRadioButton rdbtnNewRadioButtonMale = new JRadioButton("Male");
	JRadioButton rdbtnNewRadioButtonFemale = new JRadioButton("Female");
	JRadioButton rdbtnOthers = new JRadioButton("Others");
	/**
	 * Launch the application.
	 */
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BachelorAccountEditWindow window = new BachelorAccountEditWindow(email,errorCheck,count159);
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
					BachelorAccountEditWindow window = new BachelorAccountEditWindow(email,errorCheck,count159);
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
	public BachelorAccountEditWindow(String email,boolean errorCheck,int count159) {
		this.email=email;
		this.errorCheck=errorCheck;
		this.count159=count159;
		Connect();
		Connect2();
		Connect3();
		initialize();
		retrieveInfoFromTable();
		 f() ;
	}
	
	public void f() {
		if(errorCheck==true) {
			 lblMsg.setText("can not be Edited!");
		}
		else if(count159==1 && errorCheck==false ) {
			lblMsg.setText("Done!");
		}
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
	//error=0

	private void initialize() {
		//frame = new JFrame();
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
		lblFirstName.setBounds(51, 51, 65, 28);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblNID = new JLabel("NID");
		lblNID.setForeground(Color.WHITE);
		lblNID.setHorizontalAlignment(SwingConstants.CENTER);
		lblNID.setBounds(51, 158, 65, 28);
		frame.getContentPane().add(lblNID);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setBounds(51, 197, 65, 28);
		frame.getContentPane().add(lblGender);
		
		textFirstName = new JTextField("");
		textFirstName.setBackground(Color.GRAY);
		textFirstName.setForeground(Color.WHITE);
		textFirstName.setBounds(126, 55, 146, 20);
		frame.getContentPane().add(textFirstName);
		textFirstName.setColumns(10);
		
		textNID = new JTextField("");
		textNID.setForeground(Color.WHITE);
		textNID.setBackground(Color.GRAY);
		textNID.setColumns(10);
		textNID.setBounds(126, 162, 197, 20);
		frame.getContentPane().add(textNID);
		
		
		//btnNewButton.setBounds(512, 375, 89, 23);
		//frame.getContentPane().add(btnNewButton);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLastName.setBounds(51, 82, 65, 28);
		frame.getContentPane().add(lblLastName);
		
		textLastName = new JTextField("");
		textLastName.setForeground(Color.WHITE);
		textLastName.setBackground(Color.GRAY);
		textLastName.setColumns(10);
		textLastName.setBounds(126, 86, 146, 20);
		frame.getContentPane().add(textLastName);
		
		textPhoneNumber = new JTextField("");
		textPhoneNumber.setForeground(Color.WHITE);
		textPhoneNumber.setBackground(Color.GRAY);
		textPhoneNumber.setColumns(10);
		textPhoneNumber.setBounds(136, 125, 136, 20);
		frame.getContentPane().add(textPhoneNumber);
		
		JLabel lblPhoneNumber = new JLabel(" Phone Number");
		lblPhoneNumber.setForeground(Color.WHITE);
		lblPhoneNumber.setBounds(20, 119, 96, 28);
		frame.getContentPane().add(lblPhoneNumber);
		
		//JRadioButton rdbtnNewRadioButtonMale = new JRadioButton("Male");
		rdbtnNewRadioButtonMale.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButtonMale.setForeground(Color.WHITE);
		rdbtnNewRadioButtonMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender=rdbtnNewRadioButtonMale.getText();
			}
		});
		buttonGroup.add(rdbtnNewRadioButtonMale);
		rdbtnNewRadioButtonMale.setBounds(122, 200, 57, 23);
		frame.getContentPane().add(rdbtnNewRadioButtonMale);
		
		//JRadioButton rdbtnNewRadioButtonFemale = new JRadioButton("Female");
		rdbtnNewRadioButtonFemale.setBackground(Color.DARK_GRAY);
		rdbtnNewRadioButtonFemale.setForeground(Color.WHITE);
		rdbtnNewRadioButtonFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender=rdbtnNewRadioButtonFemale.getText();
			}
		});
		buttonGroup.add(rdbtnNewRadioButtonFemale);
		rdbtnNewRadioButtonFemale.setBounds(181, 200, 65, 23);
		frame.getContentPane().add(rdbtnNewRadioButtonFemale);
		
		//JRadioButton rdbtnNewRadioButton_1_1_1 = new JRadioButton("Others");
		rdbtnOthers.setBackground(Color.DARK_GRAY);
		rdbtnOthers.setForeground(Color.WHITE);
		rdbtnOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender=rdbtnOthers.getText();
			}
		});
		buttonGroup.add(rdbtnOthers);
		rdbtnOthers.setBounds(248, 200, 65, 23);
		frame.getContentPane().add(rdbtnOthers);
		
		textAddress = new JTextField("");
		textAddress.setForeground(Color.WHITE);
		textAddress.setBackground(Color.GRAY);
		textAddress.setColumns(10);
		textAddress.setBounds(126, 230, 197, 20);
		frame.getContentPane().add(textAddress);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(51, 226, 65, 28);
		frame.getContentPane().add(lblAddress);
		//int count90=1;
		
		//here

		
		System.out.print("gg"+perception);
		lblMsg.setForeground(Color.RED);
	
		
		lblMsg.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMsg.setBounds(1325, 972, 308, 28);
		frame.getContentPane().add(lblMsg);
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count159=0;
				errorCheck=false;
				bachelorMenu n=new bachelorMenu(email,"bachelor");
				n.mainBachelor2();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(1748, 977, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setBackground(Color.DARK_GRAY);
		
		 System.out.print("gender="+gender);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				 // Replace with the email you want to update
				   
				String firstName = textFirstName.getText();
				System.out.println(firstName);
				String lastName = textLastName.getText();
				System.out.println(lastName);
				String phoneNumber = textPhoneNumber.getText();
				System.out.print(phoneNumber);
				String nID = textNID.getText();
				System.out.println(nID);
				
				
				String gender_ = gender;
				System.out.println(gender_);
				
				String address = textAddress.getText();
				System.out.println(address);

				lblMsg.setForeground(Color.RED);
             
				try {
				    if (firstName.equals("") || lastName.equals("") || phoneNumber.equals("") || nID.equals("") || gender_.equals("") || address.equals("")) {
				        System.out.print("Hi1");
				    	throw new SQLException();
				   
				    }
				    if (CheckNID(nID, 13) == false) {
				        System.out.print("Hi2");
				        throw new SQLException();
				    }
				    if (CheckPhoneNumber(phoneNumber, 11) == false) {
				        System.out.print("Hi3");
				        throw new SQLException();
				    }

				    // Assuming 'perception' is your table name
				    String updateQuery = "UPDATE " + "bachelor"
				            + " SET firstName=?, lastName=?, phoneNumber=?, nID=?, gender=?, address=? WHERE email=?";
				    pst = con.prepareStatement(updateQuery);
				    System.out.println("1");
				    pst.setString(1, firstName);
				    System.out.println("2");
				    pst.setString(2, lastName);
				    System.out.println("3");
				    pst.setString(3, phoneNumber);
				    System.out.println("4");
				    pst.setString(4, nID);
				    System.out.println("5");
				    pst.setString(5, gender_);
				    System.out.println("6");
				    pst.setString(6, address);
				    System.out.println("7");
				
				    
				    System.out.println("8");
				    pst.setString(7, email); // Update based on email
				    System.out.println("9");
				     pst.executeUpdate();
				     System.out.println("10");
				     errorCheck=false;
				     count159=1; 
				   
				} catch (SQLException e1) {
				    System.out.print("error=" + e1.getErrorCode());
				    e1.printStackTrace();
				      errorCheck=true;
				      
				   

				   
				}
				
				
				BachelorAccountEditWindow a=new BachelorAccountEditWindow(email,errorCheck,count159);
				a.main();
				/*if(errorCheck==true) {
					 lblMsg.setText("can not Edited!");
				}
				else {
					lblMsg.setText("Done!");
				}*/
				frame.setVisible(false);
				
				}
	
		 
			
		}); 	
				
		btnEdit.setBounds(1649, 977, 89, 23);
		frame.getContentPane().add(btnEdit);
		
		JLabel lblNewLabel = new JLabel("13 digit");
		lblNewLabel.setBounds(333, 165, 74, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDigit = new JLabel("11 digit");
		lblDigit.setBounds(282, 128, 74, 14);
		frame.getContentPane().add(lblDigit);
		
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

public void retrieveInfoFromTable() {     
try {
	

	  pst3 = con3.prepareStatement("select firstName, lastName, nID, Gender, address, phoneNumber from bachelor where email = ?");
      pst3.setString(1, email);
      rs3=pst3.executeQuery();
      
      
      if(rs3.next()==true)
    
    {     int x=0;
    	  String firstName=rs3.getString(1);
    	  
    	  String lastName=rs3.getString(2);
    	  long nid = rs3.getLong(3);
    	 
    	    gender =rs3.getString(4);
    	   String address=rs3.getString(5);
    	        	  
    	   long phoneNumber=rs3.getLong(6);
    	
    	   
    	   textFirstName.setText(firstName);
    	   textLastName.setText(lastName);
    	   textNID.setText(String.valueOf(nid));
    	   textPhoneNumber.setText("0"+String.valueOf(phoneNumber));
    	   textAddress.setText(address);
    	   
    	   if(gender.equals("Male")) {rdbtnNewRadioButtonMale.setSelected(true);}
    	   if(gender.equals("Female")) {rdbtnNewRadioButtonFemale.setSelected(true);}
    	   if(gender.equals("Others")) {rdbtnOthers.setSelected(true);}
    	   
    
    	 
          
    	   
    	  
    	  
    	   
    	   
    } 
	  
}catch(Exception e) {
	System.out.print(e);
	System.out.print("Monkey");
}
}
}

