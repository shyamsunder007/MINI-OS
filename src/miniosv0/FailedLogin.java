package miniosv0;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class FailedLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void FailedLoginScreen(String[] args) {
		try {
			FailedLogin dialog = new FailedLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public FailedLogin() {
		setBounds(100, 100, 448, 92);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JTextArea txtrFailedLogin = new JTextArea();
			txtrFailedLogin.setBackground(Color.RED);
			txtrFailedLogin.setForeground(Color.WHITE);
			txtrFailedLogin.setFont(new Font("Consolas", Font.PLAIN, 43));
			txtrFailedLogin.setText("   FAILED LOGIN");
			txtrFailedLogin.setBounds(0, 0, 432, 58);
			contentPanel.add(txtrFailedLogin);
		}
	}

}
