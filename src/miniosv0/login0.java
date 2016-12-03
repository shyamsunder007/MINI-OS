package miniosv0;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.ComponentOrientation;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class login0 extends JFrame {
	private JTextField txtLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login0 frame = new login0();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login0() {
		setTitle("MINI_OS");
		getContentPane().setForeground(Color.BLUE);
		getContentPane().setBackground(Color.BLUE);
		setFont(new Font("Consolas", Font.PLAIN, 16));
		setBackground(Color.BLUE);
		setForeground(Color.BLUE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.GRAY);
		panel.setBounds(99, 64, 219, 129);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtLogin = new JTextField();
		txtLogin.setEditable(false);
		txtLogin.setBounds(0, 0, 219, 30);
		panel.add(txtLogin);
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setBackground(Color.GRAY);
		txtLogin.setForeground(Color.BLACK);
		txtLogin.setFont(new Font("Courier New", Font.PLAIN, 16));
		txtLogin.setText("LOGIN");
		txtLogin.setColumns(10);
		
		JLabel lblUsername = new JLabel("UserName  :");
		lblUsername.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblUsername.setBounds(10, 42, 77, 14);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password  :");
		lblPassword.setFont(new Font("Consolas", Font.PLAIN, 12));
		lblPassword.setBounds(10, 71, 77, 14);
		panel.add(lblPassword);
		passwordField = new JPasswordField(10);
		passwordField.setBackground(Color.BLUE);
		passwordField.setForeground(Color.WHITE);
		passwordField.setEchoChar('#');
		passwordField.setFont(new Font("Courier New", Font.PLAIN, 12));
		passwordField.setBounds(97, 71, 112, 14);
		panel.add(passwordField);
		textField = new JTextField();
		textField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.BLUE);
		textField.setFont(new Font("Consolas", Font.PLAIN, 12));
		textField.setBounds(97, 41, 112, 14);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Username=textField.getText();
				String password=passwordField.getText();
				if(Username.equals("shyam")&& password.equals("iiits@123") )
				{
					PageOne po=new PageOne();
					po.main(null);
				//	testcmdd c=new testcmdd();
					//c.cmd(null);
					dispose();
				}
				else
				{
					FailedLogin.FailedLoginScreen(null);
					
								
				}
				textField.setText("");
				passwordField.setText("");
				
			}
		});
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnNewButton.setBounds(20, 96, 77, 23);
		panel.add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText("");
			passwordField.setText("");
			}
			
		});
		btnReset.setFont(new Font("Consolas", Font.PLAIN, 12));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(107, 96, 77, 23);
		panel.add(btnReset);
	}
}
