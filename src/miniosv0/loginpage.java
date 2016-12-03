package miniosv0;
import java.sql.*; 
import java.awt.Image;
import java.awt.EventQueue;
import javax.swing.*;  
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginpage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginpage window = new loginpage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    Connection connection=null;
    private JTextField textFieldUn;
    private JPasswordField passwordField;
	/**
	 * Create the application.
	 */
	public loginpage() {
		initialize();
		connection=sqldatabase.dbConnector();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(250, 250, 210));
		frame.getContentPane().setForeground(Color.YELLOW);
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 10));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldUn = new JTextField();
		textFieldUn.setFont(new Font("Lucida Bright", Font.PLAIN, 11));
		textFieldUn.setBounds(279, 70, 118, 20);
		frame.getContentPane().add(textFieldUn);
		textFieldUn.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsername.setBackground(new Color(240, 240, 240));
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setBounds(175, 72, 81, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Password");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(175, 121, 73, 14);
		frame.getContentPane().add(lblNewLabel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JButton btnLogin = new JButton("Login");
		Image img=new ImageIcon(this.getClass().getResource("/ok.png")).getImage();
		btnLogin.setIcon(new ImageIcon(img));
		btnLogin.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent arg0) {
				 try{
					 String query="select * from useid where username=? and password=?";
					 PreparedStatement pst=connection.prepareStatement(query);
					 pst.setString(1,textFieldUn.getText() );
					 pst.setString(2,passwordField.getText() );
					 ResultSet rs=pst.executeQuery();
					 int count=0;
					 while(rs.next()){
						 count=count+1;
					 }
					 if (count ==1)
					 {
						 PageOne po=new PageOne();
							po.main(null);
						//	testcmdd c=new testcmdd();
							//c.cmd(null);
							frame.dispose();
					 }
					 else if (count > 1)
					 {
						 JOptionPane.showMessageDialog(null,"Duplicate Username");
					 }
					 else
					 {

							FailedLogin.FailedLoginScreen(null);
							
					 }
				     rs.close();
				     pst.close();
				 }catch(Exception e)
				 {
					 JOptionPane.showMessageDialog(null,e); 
				 }
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnLogin.setBounds(249, 182, 109, 34);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(279, 119, 118, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.ORANGE);
		Image img1=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		lblNewLabel_1.setIcon(new ImageIcon(img1));
		lblNewLabel_1.setBounds(25, 70, 155, 146);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblMiniOperatingSystem = new JLabel("Mini Operating System");
		lblMiniOperatingSystem.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 18));
		lblMiniOperatingSystem.setBounds(110, 11, 469, 48);
		frame.getContentPane().add(lblMiniOperatingSystem);
	}
}
