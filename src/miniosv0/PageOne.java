package miniosv0;
import javax.swing.*;
import javax.swing.text.View;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
class PageOne extends JFrame
{
JButton b1 = new JButton(new ImageIcon("i5.png"));
JButton b2 = new JButton(new ImageIcon("i6.png"));
JButton b3 = new JButton(new ImageIcon("i7.png"));
JButton b4 = new JButton(new ImageIcon("i9.png"));
JButton b5 = new JButton(new ImageIcon("i8.png"));
JButton b6 = new JButton(new ImageIcon("game.png"));
JButton b7 = new JButton(new ImageIcon("calendar.png"));
JButton b8 = new JButton(new ImageIcon("calculator.png"));
JButton b9 = new JButton(new ImageIcon("brow2.png"));

public PageOne()
    {
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	//System.out.println("HI");
		testcmdd c=new testcmdd();
			c.cmd(null);
		}
	});
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
//	System.out.println("HI");
			texteditor0 te=new texteditor0();
	        te.textedit(null, null);
	        
		}
	});
	b3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
//	System.out.println("HI");
			 MainApp mp=new MainApp();
		        try {
					mp.DiskScheduling(null);
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	});
	b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	//System.out.println("HI");
			framepage fp=new framepage();
    		fp.pagefault(null);
		}
	});
	b5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	//System.out.println("HI");
		dispose();
	//		 File f = new File("D:");
		//	 dir=dir+"/"+b[i].getText();
				 
             // array of files and directory
      //       String[] paths = f.list();
	//	System.out.println(paths);
        //     AppOne ap=new AppOne(paths);
		
		}
	});
	b7.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	//System.out.println("HI");
			ForCal calc=new ForCal();
			calc.main(null);
		}
	});
	b8.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			SwingCalculator c=new SwingCalculator();		      
		c.main(null);
		}
	});
	b6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	//System.out.println("HI");
			ForTictactoe game =new ForTictactoe();
			game.main(null);
			
		}
	});
	b9.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
	//System.out.println("HI");
	//		ForTictactoe game =new ForTictactoe();
		//	game.main(null);
			browser dude =new browser();
			dude.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
		}
	});
    setTitle("Desktop");
    setSize(600,400);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
    setLayout(new BorderLayout());
    setContentPane(new JLabel(new ImageIcon("F:\\Desktop\\a.jpg")));
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(b5);
    add(b6);
    add(b7);
    add(b8);
    add(b9);
    b1.setBounds(10,25,50,50);
    b2.setBounds(80,25,50,50);		
    b3.setBounds(150,25,50,50);
    b4.setBounds(220,25,50,50);
    b6.setBounds(10,300,50,50);
    b7.setBounds(80,300,50,50);
    b8.setBounds(150,300,50,50);
    b9.setBounds(220,300,50,50);
    b5.setBounds(520,300,50,50);
    
    
    setSize(599,399); 
    }
    public static void main(String args[])
    { 
    new PageOne();
    }
} 