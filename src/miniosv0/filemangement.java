package miniosv0;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UnsupportedLookAndFeelException;


	class AppOne extends JFrame
	{
		int i;
	//JButton[] b1 = new JButton(new ImageIcon("i5.png"));
String dir="D:";
	public AppOne(String[] args)
	    {
		JButton[] b=new JButton[1000];
		JButton xx=new JButton(new ImageIcon("i5.png"));
	//	int i;
		System.out.println(args.length);
		  int x=10,y=25;
			
		for( i=0;i<args.length;i++)
{	xx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		//System.out.println("HI");
		//		ForTictactoe game =new ForTictactoe();
			//	game.main(null);
				
				 File f = new File(dir);
				 dir=dir+"/"+xx.getText();
					 
                 // array of files and directory
                 String[] paths = f.list();
                    
                 // for each name in the path array
           //      for(String path:paths)
             //    {
                    // prints filename and directory name
                //    System.out.println(path);
         // textArea.append("\n");
             //               System.out.println(f.isDirectory());
           //                 textArea.append(f.isDirectory()+"");
               //}
              new AppOne(paths);
	//			browser dude =new browser();
		//		dude.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				
			}
		});
	
xx.setText(args[i]);
if(x<=520&&y<=300)
{

System.out.println(x+""+y+" "+xx.getText());
	xx.setBounds(x, y, 50, 50);
	x+=70;
}
if(x>520)
{
	x=10;
	y+=80;

System.out.println(x+""+y+xx.getText());
	xx.setBounds(x, y, 50, 50);
	
}
if(y>300)
	break;
//System.out.println(x+""+y);

add(xx);
}	//    setTitle("Desktop");
	    setSize(600,400);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    setVisible(true);
	    setLayout(new BorderLayout());

	    setContentPane(new JLabel(new ImageIcon("F:\\Desktop\\a.jpg")));
	    	    setSize(600,400); 
	    }
	 public void main(String args[])
	    { 
	    new AppOne(args);
	    }
}

