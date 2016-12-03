package miniosv0;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;

import org.eclipse.swt.graphics.Font;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.awt.event.ActionEvent;

public class texteditor0 {

	private JFrame frmVim;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	static String aa,path;
	public void textedit(String args,String pat) {
	aa=new String();
	aa=args;
	path=new String();
	path=pat;
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					texteditor0 window = new texteditor0();
					window.frmVim.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public texteditor0() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVim = new JFrame();
		frmVim.setTitle("VIM");
		frmVim.getContentPane().setBackground(Color.BLUE);
		frmVim.setBounds(100, 100, 450, 300);
		frmVim.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmVim.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 434, 31);
		frmVim.getContentPane().add(panel);
		panel.setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(278, 11, 146, 14);
		panel.add(progressBar);
	        //textArea.setBounds(77, 310, 474, 136);

	        JScrollPane scroll = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scroll.setBackground(Color.BLACK);
	        scroll.setBounds(10, 32, 414, 193);
	        frmVim.getContentPane().add(scroll);
	        
	         final JTextArea textArea = new JTextArea();
	         textArea.setBackground(Color.BLACK);
	         textArea.setForeground(Color.WHITE);
	         textArea.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 15));
	         textArea.setCaretColor(Color.WHITE);
	         textArea.setText(aa);
	         scroll.setViewportView(textArea);
	         //       textArea.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
	                textArea.setLineWrap(true);
	                
	                JButton btnSave = new JButton("Save");
	                btnSave.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
	                		
	                		if(path==null)
	                			path = JOptionPane.showInputDialog("File Name",
	                					"Enter File Name: ");
	                		String gf=new String();
	                		gf="F:\\";
	                		try(  PrintWriter out = new PrintWriter(gf+path)  ){
	                		    out.println( textArea.getText());
	                		    System.out.println(gf+path+"\n"+textArea.getText());
		                		
	                		} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	                	}
	                });
	                btnSave.setBounds(20, 236, 89, 23);
	                frmVim.getContentPane().add(btnSave);
	                
	                JButton btnRevert = new JButton("Revert");
	                btnRevert.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
	                	textArea.setText(aa);
	                	}
	                });
	                btnRevert.setBounds(130, 236, 89, 23);
	                frmVim.getContentPane().add(btnRevert);
	                
	                JButton btnClose = new JButton("Close");
	                btnClose.addActionListener(new ActionListener() {
	                	public void actionPerformed(ActionEvent e) {
	                		    frmVim.dispose();
	                	}
	                });
	                btnClose.setBounds(335, 236, 89, 23);
	                frmVim.getContentPane().add(btnClose);
	                
	        }
	

}
