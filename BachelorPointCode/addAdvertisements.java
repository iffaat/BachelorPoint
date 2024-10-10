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
public class addAdvertisements {
	String email="";
	   int k;
	   int p=1;
	   int p2=1;
	   int p3=1;
	   int p4=1;
	   int p5=1;
	   int p6=1;
	   int p7=1;
String[] Address=new String[10];
String[] Address2=new String[10];
String[] Address3=new String[10];
String[] Address4=new String[3];
String[] img=new String[30];
String Address5=new String();  //JLabel lblNewLabel_17 ;
String Email; JLabel lblNewLabel_17 = new JLabel("");
TextArea textDescription = new TextArea();

int q1,q2,q3,q4=0; 
int liftAvailablity=0;
	JLabel lblNewLabel = new JLabel("");
	JLabel lblNewLabel2 = new JLabel("");
	JLabel lblNewLabel3 = new JLabel("");
	DefaultComboBoxModel<String> comboBoxModelF= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModelG= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModelE= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModelH= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModelI= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModelk= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModelz= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModeln= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModeLift= new DefaultComboBoxModel<>();
	DefaultComboBoxModel<String> comboBoxModelGender= new DefaultComboBoxModel<>();
	JComboBox<String> comboBox = new JComboBox<>();
	JComboBox<String> comboBox420 = new JComboBox<>();
	JComboBox<String> comboBox450 = new JComboBox<>();
	String gender="Male";
	
	//JButton [] intArray = new JButton[10];
	ArrayList<JButton> intArray = new ArrayList<JButton>();
	ArrayList<JButton> intArray2 = new ArrayList<JButton>();
	ArrayList<JButton> intArray3 = new ArrayList<JButton>();
	JButton btnFamilyRoom= new JButton("");
	JButton btnDiningRoom= new JButton("");
	JButton btnKitchen= new JButton("");
	private JFrame frame;
	boolean b=false;
	boolean b2=false;
	boolean b3=false;
	int x=0;
	int x2=0;
	int x3=0;
int contain=0;
private JComboBox comboBox_Q1;
JComboBox comboBox_Q2 = new JComboBox();
JComboBox comboBox_Q3 = new JComboBox();
JComboBox comboBox_Q4 = new JComboBox(); 
JComboBox comboBox_2 = new JComboBox();  
private JTextField textArea;
private JTextField textRentPerMonth;

	/**
	 * Launch the application.
	 */
Connection con;
PreparedStatement pst;
ResultSet rs;
Connection con2;
PreparedStatement pst2;
ResultSet rs2;
private JTextField textAddress;
private JTextField textFloor;
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
public void Connect2() {
    try {
        Class.forName("com.mysql.jdbc.Driver");
        con2 = DriverManager.getConnection("jdbc:mysql://localhost/bachelor point", "root", "");
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
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

private static byte[] toByteArray(BufferedImage img) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    ImageIO.write(img, "png", outputStream);
    return outputStream.toByteArray();
}



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addAdvertisements window = new addAdvertisements();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addAdvertisements window = new addAdvertisements(Email);
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
	public addAdvertisements() {
		 Connect();
		 Connect2();
		 initialize();
	
	}
    
	public addAdvertisements(String Email) {
	this.Email=Email;
		Connect();
		 Connect2();
		initialize();
		 
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
    public static boolean isEven(int number) {
        return number % 2 == 0;
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
	 public static int charToInt(char character) {
	        return (int) character;
	    }
	 
	 
		public boolean CheckStringContainsOnlyInt (String s) {
		    int x;
 		    int count=0;;
		    
 		    for(int i=0;i<s.length();i++) { 		 	   
 		 	  x=charToInt(s.charAt(i));		 	
 		 	  
 		 	  if(x>=48 && x<=57) { 		 		  
 		 		 count=count+1; 		 		 
 		 		  System.out.print(s.charAt(i));		 		 
 		 	  }
 		 		 	  
 		    }
 		    
 		    if(count==s.length()) {System.out.println(count); return true;}
 		    else {System.out.println("false paisi"); System.out.println(count);System.out.println(s.length()); return false;}
 		    
 		
 		}
		
		public void f() {ImageIcon backgroundImageIcon = new ImageIcon("C:/Users/bad98/OneDrive/Desktop/3607424.jpg"); 
		 JLabel backgroundLabel = new JLabel(backgroundImageIcon);
		 backgroundLabel.setBounds(0, 0, backgroundImageIcon.getIconWidth(), backgroundImageIcon.getIconHeight());
	    frame.setContentPane(backgroundLabel);	
		}
	private void initialize() {
		
		
		
		
		for(int i=0;i<10;i++) {
			Address[i]=null;
			Address2[i]=null;
			Address3[i]=null;
			
		}
		//System.out.print(Address.length);
		for(int i=0;i<3;i++) {
			
			Address4[i]=null;
			
		}
		frame =new JFrame();
		frame.setBounds(0, 0, 1920, 1080);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		 f() ;
		
		
		lblNewLabel.setVisible(false);
		lblNewLabel2.setVisible(false);
		
		  for(int i=1;i<10;i++) {
	    	   comboBoxModelF.addElement(""+i);
	    	   comboBoxModelE.addElement(""+i);
	    	   comboBoxModelG.addElement(""+i);
	    	   comboBoxModelz.addElement(""+i);
	    	}
		
		JRadioButton rdbtnLivingRoom = new JRadioButton("");
		rdbtnLivingRoom.setBackground(Color.GRAY);
		rdbtnLivingRoom.setBounds(95, 54, 21, 23);
		frame.getContentPane().add(rdbtnLivingRoom);
		
		
		JLabel lblLivingRoom = new JLabel("Living Room");
		lblLivingRoom.setForeground(Color.WHITE);
		lblLivingRoom.setBounds(10, 54, 79, 23);
		frame.getContentPane().add(lblLivingRoom);
		
		JLabel lblNewLabel_1 = new JLabel("Yes");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(78, 33, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Family Room");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(10, 88, 79, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dining Room");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(10, 113, 79, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Kitchen");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(10, 138, 79, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Washroom");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(10, 163, 79, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		JRadioButton rdbtnFamilyRoom = new JRadioButton("");
		rdbtnFamilyRoom.setBackground(Color.GRAY);
		rdbtnFamilyRoom.setBounds(95, 80, 21, 23);
		frame.getContentPane().add(rdbtnFamilyRoom);
		
		JRadioButton rdbtnDiningRoom = new JRadioButton("");
		rdbtnDiningRoom.setBackground(Color.GRAY);
		rdbtnDiningRoom.setBounds(95, 106, 21, 23);
		frame.getContentPane().add(rdbtnDiningRoom);
		
		JRadioButton rdbtnKitchen = new JRadioButton("");
		rdbtnKitchen.setBackground(Color.GRAY);
		rdbtnKitchen.setBounds(95, 132, 21, 23);
		frame.getContentPane().add(rdbtnKitchen);
		
		JRadioButton rdbtnWashroom = new JRadioButton("");
		rdbtnWashroom.setBackground(Color.GRAY);
		rdbtnWashroom.setBounds(95, 158, 21, 23);
		frame.getContentPane().add(rdbtnWashroom);
		
		JLabel lblNewLabel_6 = new JLabel("Balcony");
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(10, 188, 79, 14);
		frame.getContentPane().add(lblNewLabel_6);
		
		JRadioButton rdbtnBalcony = new JRadioButton("");
		rdbtnBalcony.setBackground(Color.GRAY);
		rdbtnBalcony.setBounds(95, 184, 21, 23);
		frame.getContentPane().add(rdbtnBalcony);
		
		JLabel lblNewLabel_7 = new JLabel("How many Living rooms have washroom and balcony togather?");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(10, 229, 400, 23);
		frame.getContentPane().add(lblNewLabel_7);
		
		JComboBox comboBox_1 = new JComboBox();
	
		
		 for(int i=0;i<10;i++) {
	    	   
	    	   comboBoxModelH.addElement(""+i);
	    	   comboBoxModelI.addElement(""+i);
	    	   comboBoxModelk.addElement(""+i);
	    	   comboBoxModeln.addElement(""+i);
	    	   
	    	}
		 comboBox_Q1 = new JComboBox(comboBoxModeln);
		 comboBox_Q1.setBounds(10, 250, 46, 22);
		 frame.getContentPane().add(comboBox_Q1);
		 
		 JLabel lblNewLabel_8 = new JLabel("How many living rooms have only washroom?");
		 lblNewLabel_8.setForeground(Color.WHITE);
		 lblNewLabel_8.setBounds(10, 283, 300, 14);
		 frame.getContentPane().add(lblNewLabel_8);
		 
		 //JComboBox comboBox_Q2 = new JComboBox();
		
		 comboBox_Q2 = new JComboBox(comboBoxModelH);
	     comboBox_Q2.setBounds(10, 308, 46, 22);
		 frame.getContentPane().add(comboBox_Q2);
		 
		 JLabel lblNewLabel_9 = new JLabel("How many living rooms have only balcony?");
		 lblNewLabel_9.setForeground(Color.WHITE);
		 lblNewLabel_9.setBounds(10, 341, 307, 14);
		 frame.getContentPane().add(lblNewLabel_9);
		 
		 
		
		 comboBox_Q3 = new JComboBox(comboBoxModelI);
		 comboBox_Q3.setBounds(10, 366, 46, 22);
	
		 frame.getContentPane().add(comboBox_Q3);
		 
		 JLabel lblNewLabel_9_1 = new JLabel("Is there any central washroom ");
		 lblNewLabel_9_1.setForeground(Color.WHITE);
		 lblNewLabel_9_1.setBounds(10, 395, 231, 14);
		 frame.getContentPane().add(lblNewLabel_9_1);
		 
		 JLabel lblNewLabel_10 = new JLabel("for those people who don't have washroom");
		 lblNewLabel_10.setForeground(Color.WHITE);
		 lblNewLabel_10.setBounds(10, 411, 300, 14);
		 frame.getContentPane().add(lblNewLabel_10);
	
		
		 comboBox_Q4 = new JComboBox(comboBoxModelk);
		 comboBox_Q4.setBounds(10, 455, 46, 22);
		 frame.getContentPane().add(comboBox_Q4);
		 
		 JLabel lblNewLabel_11 = new JLabel("in their living room?If so,then how many?");
		 lblNewLabel_11.setForeground(Color.WHITE);
		 lblNewLabel_11.setBounds(10, 430, 268, 14);
		 frame.getContentPane().add(lblNewLabel_11);
		 
		 JLabel lblNewLabel_12 = new JLabel("lift Availablity?");
		 lblNewLabel_12.setForeground(Color.WHITE);
		 lblNewLabel_12.setBounds(10, 575, 99, 33);
		 frame.getContentPane().add(lblNewLabel_12);
		 
		  comboBoxModeLift.addElement("NO");
		 comboBoxModeLift.addElement("Yes");
		
	
		 comboBox_2 = new JComboBox(comboBoxModeLift);
		 comboBox_2.setBounds(95, 580, 62, 22);
		 frame.getContentPane().add(comboBox_2);
		 
		 JLabel lblNewLabel_13 = new JLabel("Area");
		 lblNewLabel_13.setForeground(Color.WHITE);
		 lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_13.setBounds(10, 619, 46, 23);
		 frame.getContentPane().add(lblNewLabel_13);
		 
		 textArea = new JTextField();
		 textArea.setBounds(53, 620, 117, 20);
		 frame.getContentPane().add(textArea);
		 textArea.setColumns(10);
		 
		 JLabel lblNewLabel_14 = new JLabel("Rent Per Month");
		 lblNewLabel_14.setForeground(Color.WHITE);
		 lblNewLabel_14.setBounds(10, 723, 99, 14);
		 frame.getContentPane().add(lblNewLabel_14);
		 
		 textRentPerMonth = new JTextField();
		 textRentPerMonth.setColumns(10);
		 textRentPerMonth.setBounds(114, 720, 127, 20);
		 frame.getContentPane().add(textRentPerMonth);
		 
		 
		 JLabel lblNewLabel_15 = new JLabel("Description");
		 lblNewLabel_15.setForeground(Color.WHITE);
		 lblNewLabel_15.setBounds(10, 768, 89, 14);
		 frame.getContentPane().add(lblNewLabel_15);
		
		 textDescription.setBackground(Color.DARK_GRAY);
		 textDescription.setForeground(Color.WHITE);
		 
		 textDescription.setBounds(105, 768, 347, 263);
		 frame.getContentPane().add(textDescription);
		 
		 JButton btnNewButton = new JButton("Add");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		
		 		for(int i=0;i<30 ;i++) {		 			
		 		
		 		if(i<=8) {
		 			
		 			img[i]=Address[i];		 			
		 		}
		 	    	
		 		if(i>=9 && i<=17) {
		 			
		 			img[i]=Address2[i-9];
		 			
		 		}
		 		
		 		if(i>=18 && i<=26) {
		 			img[i]=Address3[i-18];
		 		}
		 		
		 		if(i>=27 && i<=29) {
		 			img[i]=Address4[i-27];
		 		}
		 		
		 		}
		 		
		 		for(int k=0;k<30;k++) {
		 			System.out.println(img[k]);
		 		}
		 		
		 		//comboBox_Q1.getSelectedIndex();
		 		
		 		//comboBox_Q2.getSelectedIndex();
		 	//	comboBox_Q3.getSelectedIndex();
		 		//comboBox_Q4.getSelectedIndex();
		 		//comboBox_2.getSelectedIndex();
		 	///	textArea.getText();

		 	//boolean bl=	CheckStringContainsOnlyInt(txtArea.getText());
		 //		if(bl==true) {
		 	//		int o=Integer.parseInt(txtArea.getText());  
		 	//	}
		 	//	else {throw new IllegalArgumentException();}
		 		
		 		
		 		if(CheckStringContainsOnlyInt (textArea.getText())==false) {throw new IllegalArgumentException();}
		 	
		 		textDescription.getText();
		 		
		 		
		 		if(CheckStringContainsOnlyInt (textRentPerMonth.getText())==false) {throw new IllegalArgumentException();}
		 		if(CheckStringContainsOnlyInt (textFloor.getText())==false) {throw new IllegalArgumentException();}
		 		if(CheckStringContainsOnlyInt (textArea.getText())==false) {throw new IllegalArgumentException();}
             
		 		String email2="";
		 		String email = Email;
			    String address = textAddress.getText();
			    String floor=textFloor.getText(); 
			    String sqft=textArea.getText(); 
			    String description=textDescription.getText();
			    String cpm=textRentPerMonth.getText();
			   
			    	//liftAvailablity=comboBox_2.getSelectedIndex();
			    
			    
			
			     q1=comboBox_Q1.getSelectedIndex(); 
			     q2=comboBox_Q2.getSelectedIndex();
			     q3=comboBox_Q3.getSelectedIndex();
			     q4=comboBox_Q4.getSelectedIndex();
			int count88=0;
                 try {
                	 
                
                	 pst2 = con2.prepareStatement("SELECT email FROM advertisements WHERE address = ? AND floor = ? AND sqft = ? AND description = ? AND cpm = ? AND liftAvailability = ? AND advertisementFor = ? AND q1 = ? AND q2 = ? AND q3 = ? AND q4 = ?");

//advertisements
                     pst2.setString(1, address);
                    
                     pst2.setInt(2, Integer.parseInt(floor));
                     pst2.setInt(3, Integer.parseInt(sqft));
                     pst2.setString(4, description);
                     pst2.setInt(5, Integer.parseInt(cpm));
                     pst2.setInt(6,liftAvailablity);
  			      
  			        
  			     
  			        pst2.setString(7, gender);
  			        pst2.setInt(8, q1);
  			        pst2.setInt(9, q2);
  			        pst2.setInt(10, q3);
  			        pst2.setInt(11, q4);
                     
                     ResultSet rs2 = pst2.executeQuery();
                     
                 if(rs2.next()==true)
                 {
                	email2= rs2.getString(1);
                	System.out.print("email2="+email2);
                   if(email2.equals("")||email2.equals(null)) {
                	   System.out.println("HI440");
                	   count88=0;
                   }
                   else {
                	   System.out.println("HI4401");
                	   lblNewLabel_17.setText("Duplicate entry!"); 
                	   count88=1;
                	
                	   
                   }                      
                 }   
  
                	 
                 }
                 catch(Exception e2){
                	 e2.printStackTrace();
                	 System.out.print("Exception found!");
                 }
				  
		   
			if(count88==0) {
			     try {
			    	 System.out.print("line=1");
			    	 pst = con.prepareStatement("INSERT INTO advertisements (email, address, floor, sqft, description, liftAvailability, cpm,advertisementFor, q1, q2, q3, q4, img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11, img12, img13, img14, img15, img16, img17, img18, img19, img20, img21, img22, img23, img24, img25, img26, img27, img28, img29, img30) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?,?,?,?)");
			    	 System.out.print("line=2");
			        pst.setString(1, email);
			        pst.setString(2,address);
			        System.out.print("line=3");
			        pst.setInt(3, Integer.parseInt(floor));
			        pst.setInt(4, Integer.parseInt(sqft));
			        pst.setString(5, description);
			        System.out.print("line=4");
			        pst.setInt(6,liftAvailablity);
			       // pst.setByte(6, (byte)liftAvailablity);
			        //pst.setBoolean(6, false);
			        
			        pst.setInt(7, Integer.parseInt(cpm));
			        pst.setString(8, gender);
			        pst.setInt(9, q1);
			        pst.setInt(10, q2);
			        pst.setInt(11, q3);
			        pst.setInt(12, q4);
			        
			        
			        int j=13;
			        System.out.print("line=4");
			        for (int i = 0; i <= 29; i++) {
			        	  System.out.println(j);
			        	if(img[i]==null) {
			        	pst.setNull(j, java.sql.Types.BLOB);
			        	}
			        	else{Blob imageBlob = imageToBlob(loadImage(img[i])); // Load the image and convert to Blob
			                pst.setBlob(j, imageBlob); // Set the Blob parameter in the prepared statement
			        	}
			            j=j+1;;
			          
			        }
			        
			      
			        lblNewLabel_17.setText("Added");
			    
			        
			        pst.executeUpdate();
			                       
			        
			      
			       }
			    catch (Exception e1) 
			            {       lblNewLabel_17.setText("Can not be added!");
			            
			            System.out.print(e1);
			            }
		 		   
                
			}//
                
		 	}
		 });
		 lblNewLabel_17.setForeground(Color.RED);
		 lblNewLabel_17.setHorizontalAlignment(SwingConstants.RIGHT);
		 
		
		 lblNewLabel_17.setBounds(1540, 945, 354, 24);
		 frame.getContentPane().add(lblNewLabel_17);
		 btnNewButton.setBounds(1706, 980, 89, 23);
		 frame.getContentPane().add(btnNewButton);
		 
		 JLabel lblNewLabel_16 = new JLabel("Address");
		 lblNewLabel_16.setForeground(Color.WHITE);
		 lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		 lblNewLabel_16.setBounds(188, 531, 72, 24);
		 frame.getContentPane().add(lblNewLabel_16);
		 
		 textAddress = new JTextField();
		 textAddress.setBounds(264, 533, 152, 20);
		 frame.getContentPane().add(textAddress);
		 textAddress.setColumns(10);
		 
		 JLabel lblNewLabel_18 = new JLabel("floor");
		 lblNewLabel_18.setForeground(Color.WHITE);
		 lblNewLabel_18.setBounds(264, 584, 29, 14);
		 frame.getContentPane().add(lblNewLabel_18);
		 
		 textFloor = new JTextField();
		 textFloor.setColumns(10);
		 textFloor.setBounds(303, 581, 54, 20);
		 frame.getContentPane().add(textFloor);
		 
		// JLabel lblNewLabel_17 = new JLabel("Added!");
		
		 
		 JLabel lblNewLabel_19 = new JLabel("Advertisement for");
		 lblNewLabel_19.setForeground(Color.WHITE);
		 lblNewLabel_19.setBounds(188, 623, 105, 14);
		 frame.getContentPane().add(lblNewLabel_19);
		 
		 
	
			  comboBoxModelGender.addElement("Male");
			  comboBoxModelGender.addElement("Female");
			  comboBoxModelGender.addElement("Others");
			  
		
		 
		 JComboBox comboBoxGender = new JComboBox(comboBoxModelGender);
		 comboBoxGender.setBounds(303, 619, 54, 22);
		 frame.getContentPane().add(comboBoxGender);
		 
		 JButton btnBack = new JButton("Back");
		 btnBack.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	
		 	ownerMenu o=new ownerMenu(Email);
		 	o.mainOwner2();
		 	frame.setVisible(false);
		 	
		 	}
		 });
		 btnBack.setBounds(1805, 980, 89, 23);
		 frame.getContentPane().add(btnBack);
		 
		
		 
        System.out.print(comboBox_2.getSelectedIndex());
		 
		 
		 
			
		 
		 
	
		
		 
		
		 
		 
		rdbtnLivingRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				boolean z=isEven(p2);
				 
				if(z==false) {
			
			
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(268, 38, 160, 23);
				lblNewLabel.setText("Number of living rooms?");
				lblNewLabel.setVisible(true);
				lblNewLabel.setForeground(Color.WHITE);
				frame.getContentPane().add(lblNewLabel);
			
			    comboBox = new JComboBox<>(comboBoxModelF);
				comboBox.setSelectedIndex(-1);
				comboBox.setSelectedIndex(-1);
				comboBox.setMaximumRowCount(10);
				comboBox.setMaximumRowCount(10);
				    
		
			    
				comboBox.setBounds(420, 38, 38, 22);
				frame.getContentPane().add(comboBox);
			
				//int value=(int)(comboBox).getSelectedItem();;
				//System.out.print((comboBox).getSelectedItem());
				frame.revalidate();
				frame.repaint();                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
				comboBox.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	
				        int value = comboBox.getSelectedIndex();
				        System.out.println(b);
				        if (b) { // Use if (b) instead of if (b=true)
				            System.out.println("SIZE" + intArray.size());
				            for (int i = 0; i < intArray.size(); i++) {
				                frame.getContentPane().remove(intArray.get(i));
				            }
				            intArray.clear();
				            System.out.println();
				            frame.revalidate();
				            frame.repaint();
				        }

				        System.out.print(value);
				        x = 0;

				        // Make sure value is within the valid range of indices for intArray
				        if (value >= 0 && value < 10) {
				            for (k = 0; k <= value; k++) {
				                intArray.add(new JButton("Add img" + (k + 1)));
				                (intArray.get(k)).setBounds(502, x, 100, 23);
				                
				                (intArray.get(k)).setForeground(Color.WHITE);
				                (intArray.get(k)).setBackground(Color.GRAY);
				                x = x + 34;
				                frame.getContentPane().add(intArray.get(k));
				                System.out.println("loop2=" + k);
				                System.out.println();
				            }
				            x = 0;
				            b = true;

				            frame.revalidate();
				            frame.repaint();

				            // ActionListener code for intArray buttons
				            for (int i = 0; i <= value; i++) {
				                final int index = i; // Create a final variable to capture the current index
				                (intArray.get(i)).addActionListener(new ActionListener() {
				                    public void actionPerformed(ActionEvent e) {
				                 
				                    	Address[index] = chooseDirectory();
				                        System.out.print(Address[index]);
				                      			                      
				                    }
				                });
				            }
				        }
				    }
				});

			
			
			p2=p2+1;}
				
			//added
				if(z==true) {
					frame.getContentPane().remove(lblNewLabel);
					frame.getContentPane().remove(comboBox);
					for (int i = 0; i < intArray.size(); i++) {
		                frame.getContentPane().remove(intArray.get(i));
		            }
					frame.revalidate();
		            frame.repaint();
				p2=p2+1;
				}
			}
		
		
		
		
		
		
		
		
		});
		   
		
		
		rdbtnBalcony.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean z=isEven(p);
			 
				if(z==false) {
			
				lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel2.setBounds(630, 38, 170, 14);
				lblNewLabel2.setText("Number of Balcony?");
				lblNewLabel2.setForeground(Color.WHITE);
				lblNewLabel2.setVisible(true);
				frame.getContentPane().add(lblNewLabel2);
			
			    comboBox420 = new JComboBox<>(comboBoxModelG);
				comboBox420.setSelectedIndex(-1);
				comboBox420.setSelectedIndex(-1);
				comboBox420.setMaximumRowCount(10);
				comboBox420.setMaximumRowCount(10);
				    
		
			    
				comboBox420.setBounds(792,36, 38, 22);
				frame.getContentPane().add(comboBox420);
			
				//int value=(int)(comboBox).getSelectedItem();;
				//System.out.print((comboBox).getSelectedItem());
				frame.revalidate();
				frame.repaint();
				
				comboBox420.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	
				        int value = comboBox420.getSelectedIndex();
				        System.out.println(b);
				        if (b2) { // Use if (b) instead of if (b=true)
				            System.out.println("SIZE" + intArray2.size());
				            for (int i = 0; i < intArray2.size(); i++) {
				                frame.getContentPane().remove(intArray2.get(i));
				            }
				            intArray2.clear();
				            System.out.println();
				            frame.revalidate();
				            frame.repaint();
				        }

				        System.out.print(value);
				        x2 = 0;

				        // Make sure value is within the valid range of indices for intArray
				        if (value >= 0 && value < 10) {
				            for (k = 0; k <= value; k++) {
				                intArray2.add(new JButton("Add img" + (k + 1)));
				              //  (intArray2.get(k)).setBounds(552, x, 100, 23);
				                (intArray2.get(k)).setBounds(900, x2, 89, 23);
				                (intArray2.get(k)).setForeground(Color.WHITE);
				                (intArray2.get(k)).setBackground(Color.GRAY);
				                
				                x2 = x2 + 34;
				                frame.getContentPane().add(intArray2.get(k));
				                System.out.println("loop2=" + k);
				                System.out.println();
				            }
				            x2 = 0;
				            b2 = true;

				            frame.revalidate();
				            frame.repaint();

				            // ActionListener code for intArray buttons
				            for (int i = 0; i <= value; i++) {
				                final int index = i; // Create a final variable to capture the current index
				                (intArray2.get(i)).addActionListener(new ActionListener() {
				                    public void actionPerformed(ActionEvent e) {
				                    	
					                    	Address2[index] = chooseDirectory();
					                        System.out.print(Address2[index]);
					                    		
				                    }
				                });
				            }
				        }
				    }
				});

			
			
		p=p+1;	}
		
				if(z==true) {
					frame.getContentPane().remove(lblNewLabel2);
					frame.getContentPane().remove(comboBox420);
					for (int i = 0; i < intArray2.size(); i++) {
		                frame.getContentPane().remove(intArray2.get(i));
		            }
					frame.revalidate();
		            frame.repaint();
				p=p+1;
				}
				
			}//
		
		
		
		
		
		
		});
		
		
		rdbtnWashroom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
				boolean z=isEven(p3);
				 
				if(z==false) {
			
				lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel3.setBounds(630,341, 170, 14);
				lblNewLabel3.setForeground(Color.WHITE);
				lblNewLabel3.setText("Number of Washroom");
				lblNewLabel3.setVisible(true);
				frame.getContentPane().add(lblNewLabel3);
			
			    comboBox450 = new JComboBox<>(comboBoxModelz);
				comboBox450.setSelectedIndex(-1);
				comboBox450.setSelectedIndex(-1);
				comboBox450.setMaximumRowCount(10);
				comboBox450.setMaximumRowCount(10);
				    
		
			    
				comboBox450.setBounds(792,341, 38, 22);
				frame.getContentPane().add(comboBox450);
			
				//int value=(int)(comboBox).getSelectedItem();;
				//System.out.print((comboBox).getSelectedItem());
				frame.revalidate();
				frame.repaint();
				
				comboBox450.addActionListener(new ActionListener() {
				    @Override
				    public void actionPerformed(ActionEvent e) {
				    	
				        int value = comboBox450.getSelectedIndex();
				        System.out.println(b);
				        if (b3) { // Use if (b) instead of if (b=true)
				            System.out.println("SIZE" + intArray3.size());
				            for (int i = 0; i < intArray3.size(); i++) {
				                frame.getContentPane().remove(intArray3.get(i));
				            }
				            intArray3.clear();
				            System.out.println();
				            frame.revalidate();
				            frame.repaint();
				        }

				        System.out.print(value);
				        x3 = 0;

				        // Make sure value is within the valid range of indices for intArray
				        if (value >= 0 && value < 10) {
				            for (k = 0; k <= value; k++) {
				                intArray3.add(new JButton("Add img" + (k + 1)));
				              //  (intArray2.get(k)).setBounds(552, x, 100, 23);
				                (intArray3.get(k)).setBounds(900, x3+341, 89, 23);
				                (intArray3.get(k)).setForeground(Color.WHITE);
				                (intArray3.get(k)).setBackground(Color.GRAY);
				                
				                x3 = x3 + 34;
				                frame.getContentPane().add(intArray3.get(k));
				                System.out.println("loop2=" + k);
				                System.out.println();
				            }
				            x3 = 0;
				            b3 = true;

				            frame.revalidate();
				            frame.repaint();

				            // ActionListener code for intArray buttons
				            for (int i = 0; i <= value; i++) {
				                final int index = i; // Create a final variable to capture the current index
				                (intArray3.get(i)).addActionListener(new ActionListener() {
				                    public void actionPerformed(ActionEvent e) {
				                    	
					                    	Address3[index] = chooseDirectory();
					                        System.out.print(Address3[index]);
					                      	
				                    }
				                });
				            }
				        }
				    }
				});

			
			
			p3=p3+1;}
				
			//added
				if(z==true) {
					frame.getContentPane().remove(lblNewLabel3);
					frame.getContentPane().remove(comboBox450);
					for (int i = 0; i < intArray3.size(); i++) {
		                frame.getContentPane().remove(intArray3.get(i));
		            }
					frame.revalidate();
		            frame.repaint();
				p3=p3+1;
				}
			
			
			}
		
		
		
		
		
		
		
		
		});
		
		
		
		rdbtnFamilyRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean z=isEven(p4);
				 System.out.print(p4);
				if(z==false) {
				
			    btnFamilyRoom= new JButton("Add img");
			    btnFamilyRoom.setForeground(Color.WHITE);
			    btnFamilyRoom.setBackground(Color.GRAY);
			    btnFamilyRoom.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e){
					
	                    	Address4[0] = chooseDirectory();
	                        System.out.print(Address4[0]);
	                    
		            }
			
				});
				btnFamilyRoom.setBounds(141, 80, 100, 22);
				frame.getContentPane().add(btnFamilyRoom);
				frame.revalidate();
	            frame.repaint();
			
				p4=p4+1;}
		
				if(z==true) {
					System.out.println("successfully Entered");
		            frame.getContentPane().remove(btnFamilyRoom);
		            
		            System.out.println("successfully Entered");
					
				p4=p4+1;
				}
			
		frame.revalidate();
        frame.repaint();	
            }
		
			
		
		
		
		
		
		
		});
		//btnNewButton_1.setBounds(532, 38, 89, 23);
		//frame.getContentPane().add(btnNewButton_1);
		
		
		//comboBox.setBounds(484, 38, 30, 22);
		//frame.getContentPane().add(comboBox);

		
		
		rdbtnDiningRoom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean z=isEven(p5);
				 System.out.print(p5);
				if(z==false) {
				
			    btnDiningRoom= new JButton("Add img");
				btnDiningRoom.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
	                    	Address4[1] = chooseDirectory();
	                        System.out.print(Address4[1]);
	                     
		            }
			
				});
			    btnDiningRoom.setBounds(141, 106, 100, 22);
			    btnDiningRoom.setForeground(Color.WHITE);
			    btnDiningRoom.setBackground(Color.GRAY);
				frame.getContentPane().add(btnDiningRoom);
				
				frame.revalidate();
	            frame.repaint();
			
				p5=p5+1;}
		
				if(z==true) {
					System.out.println("successfully Entered");
		            frame.getContentPane().remove(btnDiningRoom);
		            
		            System.out.println("successfully Entered");
					
				p5=p5+1;
				}
			
		frame.revalidate();
        frame.repaint();	
            }
		
			
		
		
		
		
		
		
		});
		
		
		rdbtnKitchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean z=isEven(p6);
				 System.out.print(p6);
				if(z==false) {
				
					btnKitchen= new JButton("Add img");
					btnKitchen.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
	                    	Address4[2] = chooseDirectory();
	                        System.out.print(Address4[2]);
	                    
		            }
			
				});
					btnKitchen.setBounds(141, 132, 100, 22);
					btnKitchen.setForeground(Color.WHITE);
					btnKitchen.setBackground(Color.GRAY);
				frame.getContentPane().add(btnKitchen);
				
				frame.revalidate();
	            frame.repaint();
			
				p6=p6+1;}
		
				if(z==true) {
					System.out.println("successfully Entered");
		            frame.getContentPane().remove(btnKitchen);
		            
		            System.out.println("successfully Entered");
					
				p6=p6+1;
				}
			
		frame.revalidate();
        frame.repaint();	
            }
		
			
		
		
		
		
		
		
		});
		
		
	
		for(int i=0;i<10;i++) {
			System.out.println(Address3[k]);
			
		}
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		
		        liftAvailablity=comboBox_2.getSelectedIndex();		
      				
			
            }
		
		
		});
		
		//
		comboBox_Q1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		
		        q1=comboBox_Q1.getSelectedIndex();		
      				
			
            }
		
		
		});
		//
		comboBox_Q2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		
		        q2=comboBox_Q2.getSelectedIndex();		
      				
			
            }
		
		
		});
		//
		comboBox_Q3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		
		        q3=comboBox_Q3.getSelectedIndex();		
      				
			
            }
		
		
		});
		//
		comboBox_Q4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		
		        q4 =comboBox_Q4.getSelectedIndex();		
      				
			
            }
		
		
		});
		comboBoxGender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		 		
				 gender = comboBoxGender.getSelectedItem().toString();	
      				
			
            }
		
		
		});

		
		
	     
	}
}
