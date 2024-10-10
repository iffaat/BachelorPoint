import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.sql.*;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseMotionListener;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JScrollPane;
import javax.swing.*;

public class showMyAdvertisements {
    ArrayList<BufferedImage> normalImageList = new ArrayList<>();
    ArrayList<BufferedImage> NullImageList = new ArrayList<>();
    ArrayList<BufferedImage> threeDImageList = new ArrayList<>();
    BufferedImage img3;
    BufferedImage img4;
    BufferedImage[] img = new BufferedImage[30];
    Blob[] b = new Blob[30];
    int count = 1; View v;
    int count2 = 1;
    private int mouseX, mouseY;
    JInternalFrame internalFrame = new JInternalFrame("");
    JLabel lblAddress = new JLabel("");
    JLabel lblImg1 = new JLabel("");
    String email = "";
    String rowEmail = "";
    String password = "";
    String perception = "";
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    Connection con2;
    PreparedStatement pst2;
    ResultSet rs2;
   //long pNumber=0;
    Connection con3;
    PreparedStatement pst3;
    ResultSet rs3;
   
    JLabel textAns1 = new JLabel("");
    JLabel textAns2 = new JLabel("");
    JLabel textAns3 = new JLabel("");
    JLabel textAns4 = new JLabel("");
    JLabel lblGender = new JLabel("");
    JLabel lblPhoneNumber = new JLabel("");
    TextArea textDescriptionRead = new TextArea();
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
    public void Connect3() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con3 = DriverManager.getConnection("jdbc:mysql://localhost/bachelor point", "root", "");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean is360Compatible(BufferedImage image) {
        try {
            int imageWidth = image.getWidth();
            int imageHeight = image.getHeight();
            double aspectRatio = (double) imageWidth / imageHeight;
            double aspectRatioThreshold = 2.0;
            return Math.abs(aspectRatio - aspectRatioThreshold) < 0.1;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static String splitLongString(String inputString, int maxLineLength) {
        String[] words = inputString.split(" ");
        StringBuilder result = new StringBuilder();
        StringBuilder currentLine = new StringBuilder();
        int padding = 5; // Adjust the padding as needed

        for (String word : words) {
            if (currentLine.length() + word.length() + padding <= maxLineLength) {
                if (currentLine.length() > 0) {
                    currentLine.append(" ");
                }
                currentLine.append(word);
            } else {
                result.append(currentLine.toString()).append("\n");
                currentLine.setLength(0);  // Reset the current line
                currentLine.append(word);
            }
        }

        if (currentLine.length() > 0) {
            result.append(currentLine.toString());
        }

        return result.toString();
    }
    public static BufferedImage convertBlobToImage(Blob blob) {
        try {
            byte[] blobBytes = blob.getBytes(1, (int) blob.length());
            try (InputStream inputStream = new ByteArrayInputStream(blobBytes)) {
                return ImageIO.read(inputStream);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void deleteAndSetToNull(Object[] array) {
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                array[i] = null;
            }
        }
    }
    public void BlobToImageTolabeling(int id) {
        try {	
    	deleteAndSetToNull(img);
    	deleteAndSetToNull(b);
    	 NullImageList.clear();
      	 normalImageList.clear();
    	 threeDImageList.clear();
            pst = con.prepareStatement("select img1,img2,img3,img4,img5,img6,img7,img8,img9,img10,img11,img12,img13,img14,img15,img16,img17,img18,img19,img20,img21,img22,img23,img24,img25,img26,img27,img28,img29,img30 from advertisements where id= ?");
            pst.setInt(1, id);
            rs = pst.executeQuery();
            if (rs.next() == true) {
                for (int i = 0; i < 30; i++) {
                    b[i] = rs.getBlob(i + 1);
                }
                for (int i = 0; i < 30; i++) {
                	if(b[i]!=null) {
                    img[i] = convertBlobToImage(b[i]);
                    
                }
                	else { img[i]=null;}
                	}
                for (int i = 0; i < 30; i++) {
                    if (img[i] == null) {
                        NullImageList.add(img[i]);
                    } else if (is360Compatible(img[i]) == false) {
                        normalImageList.add(img[i]);
                    } else if (is360Compatible(img[i]) == true) {
                        threeDImageList.add(img[i]);
                    }
                }
                function();
                 
                internalFrame.revalidate();
                internalFrame.repaint();
                
                
                
  
                Image g = normalImageList.get(0).getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(g);
                lblImg1.setIcon(icon);
                
                frame.revalidate();
                frame.repaint();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private JFrame frame;
    private JTable table;
    public void show(String e) {    
        try {
           // String Address = "";
            //Address = txtEnterLocation.getText();
           // if (Address.equals("")) {
         //       throw new SQLException();
          //  }
            pst = con.prepareStatement("SELECT id, address, floor, sqft, cpm, liftAvailability "
                    + "FROM advertisements " + "WHERE email = ?");
            pst.setString(1,e);
            ResultSet rs = pst.executeQuery();
            
            
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            if (rs.next() == true) {
                String email = rs.getString(2);
                System.out.print("show my advertisements=="+email);
            } else {
                System.out.print("Do nothing!");
            }
        } catch (SQLException ex) {
            System.out.print("Do nothing!1");
        }
    
}
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            showMyAdvertisements window = new showMyAdvertisements();
            window.frame.setVisible(true);
        });
    }

    public void mainShowMyAdvertisements() {
        EventQueue.invokeLater(() -> {
            showMyAdvertisements window = new showMyAdvertisements(email);
            window.frame.setVisible(true);
        });
    }

    public showMyAdvertisements() {
        Connect();
        Connect2() ;
        initialize();
    }

    /**
     * @wbp.parser.entryPoint
     */
    public showMyAdvertisements(String email) {
    //	this.pNumber=pNumber;
        Connect();
        Connect2() ;
        Connect3();
        this.email = email;
       
        initialize();
        show(email);
        
        //lblPhoneNumber.setText(String.valueOf(pNumber));
       
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
        internalFrame.setTitle("360");
        internalFrame.setSize(300, 300);
        internalFrame.setBounds(1400, 104,470, 285);
        internalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        internalFrame.setResizable(false);
        internalFrame.setBackground(Color.DARK_GRAY);
        internalFrame.setVisible(true);
        // Add it to the main frame before setting its content
        frame.getContentPane().add(internalFrame);
    
        internalFrame.getContentPane().addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        });

        JScrollPane scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(10, 104, 877, 397);
    
        
        
        frame.getContentPane().add(scrollPane_1);
     
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.getViewport().setBackground(Color.DARK_GRAY);
        scrollPane_1.setViewportView(scrollPane);
        
        

        table = new JTable();
        table.setDefaultRenderer(Object.class, new CustomCellRenderer());
        scrollPane.setViewportView(table);
         
        
 
        textDescriptionRead.setBounds(20, 699, 380, 208);
        textDescriptionRead.setBackground(Color.DARK_GRAY);
        textDescriptionRead.setForeground(Color.WHITE);
        frame.getContentPane().add(textDescriptionRead);
    	JLabel lblNewLabel_7 = new JLabel("How many Living rooms have washroom and balcony togather?");
    	lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(20, 521, 365, 23);
		frame.getContentPane().add(lblNewLabel_7);
        
		 
		 JLabel lblNewLabel_8 = new JLabel("How many living rooms have only washroom?");
		 lblNewLabel_8.setForeground(Color.WHITE);
		 lblNewLabel_8.setBounds(20, 555, 307, 14);
		 frame.getContentPane().add(lblNewLabel_8);
        
		 JLabel lblNewLabel_9 = new JLabel("How many living rooms have only balcony?");
		 lblNewLabel_9.setForeground(Color.WHITE);
		 lblNewLabel_9.setBounds(20, 589, 307, 14);
		 frame.getContentPane().add(lblNewLabel_9);
		 
		 JLabel lblNewLabel_10 = new JLabel("For those people who don't have washroom \"in their living room?If so,then how many?\"");
		 lblNewLabel_10.setForeground(Color.WHITE);
		 lblNewLabel_10.setBounds(20, 623, 501, 14);
		 frame.getContentPane().add(lblNewLabel_10);
		
        
        JButton btnShow = new JButton("Show");
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	count = 1;
            	count2=1;
            	 internalFrame.getContentPane().removeAll();
                int index = table.getSelectedRow();
                System.out.println("selected index="+index);
                int value = Integer.parseInt(table.getValueAt(index, 0).toString());
                System.out.print("hello=" + value + "====");
                System.out.print(index);
          
                retrieveInfoFromTable(value) ;
                BlobToImageTolabeling(value);
                
         
             
                
            }
        });
        btnShow.setBounds(763, 64, 89, 23);
        frame.getContentPane().add(btnShow);

        lblImg1.setBounds(897, 104, 470, 285);
        frame.getContentPane().add(lblImg1);
       // JButton btnNewButton;
        JButton btnNewButton_1 = new JButton("Show Full Image");
        btnNewButton_1.setBackground(Color.DARK_GRAY);
        btnNewButton_1.setForeground(Color.WHITE);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (count2 > 0 && count2 <= threeDImageList.size()) {
                    View v = new View(threeDImageList.get(count2 - 1));
                    v.run(threeDImageList.get(count2 - 1));
                }
            }
        });
        btnNewButton_1.setBounds(1536, 425, 196, 23);
        frame.getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton(">>");
        btnNewButton_2.setBackground(Color.DARK_GRAY);
        btnNewButton_2.setForeground(Color.WHITE);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (count >= normalImageList.size()) {
                    count = 0;
                }
                Image g = normalImageList.get(count).getScaledInstance(400, 400, java.awt.Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(g);
                lblImg1.setIcon(icon);
                count = count + 1;
            }
        });
        btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
        btnNewButton_2.setBounds(1049, 391, 55, 23);
        frame.getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton(">>");
        btnNewButton_3.setBackground(Color.DARK_GRAY);
        btnNewButton_3.setForeground(Color.WHITE);
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                internalFrame.getContentPane().removeAll();
                if (!threeDImageList.isEmpty()) {
                    if (count2 >= threeDImageList.size()) {
                        count2 = 0;
                    }
                     v = new View(threeDImageList.get(count2));
                 //   internalFrame.setTitle("360");
                 //   internalFrame.setSize(300, 300);
                 //   internalFrame.setBounds(1400, 104,470, 285);
                 //   internalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  //  internalFrame.setResizable(false);

                    // Add it to the main frame before setting its content
                  //  frame.getContentPane().add(internalFrame);
                    
                    // Set the content for the JInternalFrame
                    internalFrame.getContentPane().add(v);

                    // Set it as visible
                    internalFrame.setVisible(true);

                    // Request focus and start, if needed
                    v.requestFocus();
                    v.start();
                    internalFrame.revalidate();
                    internalFrame.repaint();
                    frame.revalidate();
                    frame.repaint();
                } else {
                    System.out.println("No 3D images to display.");
                }
                count2++;
            }
        });
        btnNewButton_3.setBounds(1602, 391, 55, 23);
        frame.getContentPane().add(btnNewButton_3);
        textAns1.setForeground(Color.WHITE);
        
       // JLabel textAns1 = new JLabel("");
        textAns1.setHorizontalAlignment(SwingConstants.CENTER);
        textAns1.setBounds(441, 525, 80, 14);
        frame.getContentPane().add(textAns1);
        textAns2.setForeground(Color.WHITE);
        
      //  JLabel textAns2 = new JLabel("");
        textAns2.setHorizontalAlignment(SwingConstants.CENTER);
        textAns2.setBounds(441, 555, 80, 14);
        frame.getContentPane().add(textAns2);
        textAns3.setForeground(Color.WHITE);
        
       // JLabel textAns3 = new JLabel("");
        textAns3.setHorizontalAlignment(SwingConstants.CENTER);
        textAns3.setBounds(441, 589, 80, 14);
        frame.getContentPane().add(textAns3);
        textAns4.setForeground(Color.WHITE);
        
       // JLabel textAns4 = new JLabel("");
        textAns4.setHorizontalAlignment(SwingConstants.CENTER);
        textAns4.setBounds(545, 623, 80, 14);
        frame.getContentPane().add(textAns4);
        
        JLabel lblNewLabel = new JLabel("Address:");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBounds(1321, 521, 71, 23);
        frame.getContentPane().add(lblNewLabel);
        lblAddress.setForeground(Color.WHITE);
        lblAddress.setBackground(Color.DARK_GRAY);
        
       
        lblAddress.setBounds(1392, 525, 380, 14);
        frame.getContentPane().add(lblAddress);
        
        JLabel lblAdvertisementFor = new JLabel("Advertisement For:");
        lblAdvertisementFor.setForeground(Color.WHITE);
        lblAdvertisementFor.setBounds(1321, 567, 125, 23);
        frame.getContentPane().add(lblAdvertisementFor);
        lblGender.setForeground(Color.WHITE);
        lblGender.setBackground(Color.DARK_GRAY);
        
      
        lblGender.setBounds(1467, 567, 235, 23);
        frame.getContentPane().add(lblGender);
        
        JLabel lblNewLabel_1 = new JLabel("Phone Number:");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setBounds(1321, 601, 125, 14);
        frame.getContentPane().add(lblNewLabel_1);
        lblPhoneNumber.setForeground(Color.WHITE);
        lblPhoneNumber.setBackground(Color.DARK_GRAY);
        
     
        lblPhoneNumber.setBounds(1467, 601, 342, 14);
        frame.getContentPane().add(lblPhoneNumber);
        
        JLabel lblNewLabel_2 = new JLabel("Description");
        lblNewLabel_2.setForeground(Color.WHITE);
        lblNewLabel_2.setBounds(20, 674, 235, 14);
        frame.getContentPane().add(lblNewLabel_2);
        
        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		ownerMenu b = new ownerMenu(email);
                System.out.println("BaCK=="+email+"======");
                b.mainOwner2();
                frame.setVisible(false);
        		
        		
        	}
        });
        btnBack.setForeground(Color.WHITE);
        btnBack.setBackground(Color.DARK_GRAY);
        btnBack.setBounds(1787, 996, 107, 23);
        frame.getContentPane().add(btnBack);
    }
	public void retrieveInfoFromTable(int id_) {     
	try {System.out.println("id==seee=="+id_);
		  pst2 = con2.prepareStatement("select  address, floor, sqft, description, liftAvailability, cpm,advertisementFor, q1, q2, q3, q4, email from advertisements where id = ?");
	      pst2.setInt(1, id_);
	      rs2=pst2.executeQuery();
	      
	      
          if(rs2.next()==true)
        
        {     int x=0;
        	  String address_=rs2.getString(1);
        	  
        	  int floor_=rs2.getInt(2);
        	   int sqft_=rs2.getInt(3);
        	   String description_=rs2.getString(4);
        	   int liftAvailablity_=rs2.getInt(5);
        	  int  cpm_=rs2.getInt(6);        	  
        	  String advertisementFor_=rs2.getString(7);
        	  
        	   int q1_=rs2.getInt(8);  
        	   int q2_=rs2.getInt(9);  
        	   int q3_=rs2.getInt(10);  
        	   int q4_=rs2.getInt(11);
        	   rowEmail=rs2.getString(12);
        	      try {
                      
                      pst3 = con3.prepareStatement("SELECT phoneNumber "  
                              + "FROM owner " + "WHERE email = ?");
                      pst3.setString(1,rowEmail);
                      ResultSet rs3 = pst3.executeQuery();
                      
                      
                      
                   
                      if (rs3.next() == true) {
                     	long pNumber=rs3.getLong(1);
                     	System.out.println("Um here!"+pNumber);
                     	 lblPhoneNumber.setText("0"+String.valueOf(pNumber));
                      } else {
                          System.out.print("Do nothing!");
                      }
                  } catch (SQLException ex) {
                      System.out.print("Do nothing!1");
                  }
        	   
        	   
        	   
        	   lblAddress.setText(address_);
        	   textAns1.setText(String.valueOf(q1_));
        	   textAns2.setText(String.valueOf(q2_));
        	   textAns3.setText(String.valueOf(q3_));
        	   textAns4.setText(String.valueOf(q4_));
        	   
        	   textDescriptionRead.setText( splitLongString(description_, 60));
        	   
        	  
        	   
        	   if(advertisementFor_.equals("Male")) {lblGender.setText("Male");}
        	   if(advertisementFor_.equals("Female")) {lblGender.setText("Female");}
        	   if(advertisementFor_.equals("Others")) {lblGender.setText("Others");}
        	   
        	   
        	
        } 
		  
	}catch(Exception e) {
		System.out.print(e);
	}
	}
    public void function() {
    	v = new View(threeDImageList.get(0));
        
        
        // Set the content for the JInternalFrame
        internalFrame.getContentPane().add(v);

        // Set it as visible
        //internalFrame.setVisible(true);

        // Request focus and start, if needed
        v.requestFocus();
        v.start();
    }
}
