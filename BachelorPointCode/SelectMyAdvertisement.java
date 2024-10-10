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
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JInternalFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JScrollPane;
import javax.swing.*;

public class SelectMyAdvertisement {
    ArrayList<BufferedImage> normalImageList = new ArrayList<>();
    ArrayList<BufferedImage> NullImageList = new ArrayList<>();
    ArrayList<BufferedImage> threeDImageList = new ArrayList<>();
    BufferedImage img3;
    BufferedImage img4;
    BufferedImage[] img = new BufferedImage[30];
    Blob[] b = new Blob[30];
    int count = 1;
    int count2 = 1;
    private int mouseX, mouseY;
    JInternalFrame internalFrame = new JInternalFrame("");
    String email = "";
    String password = "";
    String perception = "";
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

    public void BlobToImageTolabeling(int value) {
       System.out.print("passing ID from select"+value);
       System.out.println("Select="+email);
        EditAdvertisements s=new EditAdvertisements(email,value);
        
        s.main3();
    }

    private JFrame frame;
    private JTable table;
   /* public void show() {    
        try {
           // String Address = "";
            //Address = txtEnterLocation.getText();
           // if (Address.equals("")) {
         //       throw new SQLException();
          //  }
            pst = con.prepareStatement("SELECT id, email, address, floor, sqft, description, cpm, liftAvailability "
                    + "FROM advertisements " + "WHERE email = ?");
            pst.setString(1,email);
            ResultSet rs = pst.executeQuery();
            
            
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            if (rs.next() == true) {
                String email = rs.getString(2);
                System.out.print(email);
            } else {
                System.out.print("Do nothing!");
            }
        } catch (SQLException ex) {
            System.out.print("Do nothing!1");
        }
    
} */
    public void show(String Email) {    
        try {
           // String Address = "";
            //Address = txtEnterLocation.getText();
           // if (Address.equals("")) {
         //       throw new SQLException();
          //  }
           // pst = con.prepareStatement("SELECT id, email, address, floor, sqft, description, cpm, liftAvailability "
                 //   + "FROM advertisements " + "WHERE email = ?");
        	
        	 pst = con.prepareStatement("SELECT id,address, floor, sqft, cpm, liftAvailability "
               + "FROM advertisements " + "WHERE email = ?");
            pst.setString(1,Email);
            ResultSet rs = pst.executeQuery();
            
            
            
            table.setModel(DbUtils.resultSetToTableModel(rs));
            if (rs.next() == true) {
                String email = rs.getString(2);
                System.out.print(email);
            } else {
                System.out.print("Do nothing!");
            }
        } catch (SQLException ex) {
            System.out.print("Do nothing!1");
        }
    
}
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SelectMyAdvertisement window = new SelectMyAdvertisement();
            window.frame.setVisible(true);
        });
    }

    public void mainShowMyAdvertisements() {
        EventQueue.invokeLater(() -> {
            SelectMyAdvertisement window = new SelectMyAdvertisement(email);
            window.frame.setVisible(true);
        });
    }

    public SelectMyAdvertisement() {
        Connect();
        initialize();
    }

    /**
     * @wbp.parser.entryPoint
     */
    public SelectMyAdvertisement(String email) {
        Connect();
        this.email = email;
        System.out.println("selectMyAdvertisements===="+email+"======");
        initialize();
        show(email);
        
       
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

        JButton btnShow = new JButton("Edit");
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = table.getSelectedRow();
                int value = Integer.parseInt(table.getValueAt(index, 0).toString());
                System.out.print("hello=" + value + "====");
                System.out.print(index);
                BlobToImageTolabeling(value);
                frame.setVisible(false);
                
            }
        });
        btnShow.setBounds(1708, 983, 89, 23);
        frame.getContentPane().add(btnShow);

        JButton btnNewButton = new JButton("Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ownerMenu b = new ownerMenu(email);
                System.out.println("BaCK=="+email+"======");
                b.mainOwner2();
                frame.setVisible(false);
            }
        });
        btnNewButton.setBounds(1805, 983, 89, 23);
        frame.getContentPane().add(btnNewButton);
    }
}
