package miniosv0;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class drawgraphpanel extends JFrame {

	private JPanel graphPanel_;
	private JLabel head;

	/**
	 * Launch the application.
	 */
	public static void hai(DrawGraph panel) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					drawgraphpanel frame = new drawgraphpanel(panel);
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
	public void setGraphPanel(DrawGraph panel) {
		graphPanel_.setLayout(new FlowLayout());
		graphPanel_.removeAll();
		graphPanel_.setPreferredSize(new Dimension(600, 400));

		graphPanel_.add(panel);
System.out.println(panel+"fgxf");
		head.setFont(new Font("Vardana", Font.BOLD, 14));
		head.setForeground(Color.BLUE);
		head.setText("Algorithm: " 
				+ " ^_^ Head Starting point: ");
		graphPanel_.add(head);
		graphPanel_.repaint();
		graphPanel_.revalidate();
	}


	public drawgraphpanel(DrawGraph panel) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		graphPanel_ = new JPanel();
		// graphPanel_.setBorder(new TitledBorder("Graph"));
		graphPanel_.setPreferredSize(new Dimension(600, 400));
		graphPanel_.setBorder(new EmptyBorder(5, 5, 5, 5));
		graphPanel_.setLayout(new BorderLayout(0, 0));
		head = new JLabel("Head Possition: ");
		graphPanel_.add(head);	
		graphPanel_.add(panel);
		setContentPane(graphPanel_);
		
		// TODO Auto-generated constructor stub
	}



}
