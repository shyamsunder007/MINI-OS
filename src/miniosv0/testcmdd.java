package miniosv0;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class testcmdd extends JFrame {

    private static final String key = "ENTER";
    private KeyStroke keyStroke;
    String curdir="F:";
    private JButton button;
    private JTextArea textArea;

    private Action wrapper = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            button.doClick();
      //      DefaultCaret caret = (DefaultCaret) textArea.getCaret();
        //    caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
         //  System.out.println(caret+"caret"); 
        //    textArea.setCaretPosition(textArea.getDocument().getLength() - 1);
        }
    };

public static void unzip(String source,String destination){
    
    String password = "password";

    try {
         ZipFile zipFile = new ZipFile(source);
         if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
         
         }
         zipFile.extractAll(destination);
    } catch (ZipException e) {
        e.printStackTrace();
    }
}
    public static void pack(String sourceDirPath, String zipFilePath) throws IOException {
        //System.out.println(sourceDirPath+" "+zipFilePath);
        Path p = Files.createFile(Paths.get(zipFilePath));

        ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p));
        try {
            Path pp = Paths.get(sourceDirPath);
            Files.walk(pp)
              .filter(path -> !Files.isDirectory(path))
              .forEach(path -> {
                  String sp = path.toAbsolutePath().toString().replace(pp.toAbsolutePath().toString(), "").replace(path.getFileName().toString(), "");
                  ZipEntry zipEntry = new ZipEntry(sp + "/" + path.getFileName().toString());
                  try {
                      zs.putNextEntry(zipEntry);
                      zs.write(Files.readAllBytes(path));
                      zs.closeEntry();
                } catch (Exception e) {
                    System.err.println(e);
                }
              });
        } finally {
            zs.close();
        }
    }
    private void displayGUI() {
        JFrame frame = new JFrame("CommandPrompt");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel(new BorderLayout(5, 5));

        textArea = new JTextArea(18, 60);
        keyStroke = KeyStroke.getKeyStroke(key);
        Object actionKey = textArea.getInputMap(
                JComponent.WHEN_FOCUSED).get(keyStroke);
        textArea.getActionMap().put(actionKey, wrapper);
       // JTextArea jTextArea = new JTextArea();
        JScrollPane scroll = new JScrollPane (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBackground(Color.BLACK);
        scroll.setBounds(10, 32, 414, 193);
        contentPane.add(scroll, BorderLayout.CENTER);
         
         textArea.setBackground(Color.BLACK);
         textArea.setForeground(Color.WHITE);
         textArea.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 15));
         textArea.setCaretColor(Color.WHITE);
         
         scroll.setViewportView(textArea);
         //       textArea.setFont(new Font("MS UI Gothic", Font.PLAIN, 13));
                textArea.setLineWrap(true);
          textArea.append("->F: ");      
       
        button = new JButton("Click Me!");
         button.addActionListener(new ActionListener() {
            private BufferedReader br;

			@Override
            public void actionPerformed(ActionEvent ae) {
             //   System.out.format(textArea.getText());
               // textArea.append("\n"+textArea.getText()+"\n");
           String totoalinfo = textArea.getText();
           String[] divideinfo = totoalinfo.split("\n");
           String command = divideinfo[divideinfo.length-1];
        //extArea.appen);
           String comm[] = new String[100000];
           comm=command.split(" ");
           String com=new String();
          
           
           if(comm.length==2)
           {
        	   com=comm[comm.length-1];
        	   }
           else
           {
        	   com=comm[1];
        	   
           }
           
           String[] fstc=new String[10000];
           fstc=command.split(" ");
          	 String dir = fstc[1];
          //	 System.out.println(com.equals("zpdir"));
         
          	 if(com.equals("exit"))
          	 {
          		 frame.dispose();
          		 
          	 }
          	 else if(com.equals("zpdir"))
         {
        //	 String path=command.substring(5).trim();
           //  String source[]=comm.split(" ");
             try {
                pack(curdir+"/"+comm[2],comm[3]);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
             textArea.append("\nSuccess\n");
             
         }
         else if(com.equals("uzpdr"))
         {
        	 
        	  String path=command.substring(4).trim();
              String source[]=path.split("\\ ");
              textArea.append("\n"+fstc[2]+" "+fstc[3]);
              unzip(curdir+"/"+fstc[2],fstc[3]);
              textArea.append("\nSuccess\n");
              
         }
         else if(com.equals("ls"))
         {
             
             System.out.println("directory contents");
             
             textArea.append("\n"+"Directory contents");
             
             File f = null;
             String[] paths;
             try{
                 f = new File(curdir);
                 
                    // array of files and directory
                    paths = f.list();
                       
                    // for each name in the path array
                    for(String path:paths)
                    {
                       // prints filename and directory name
                       System.out.println(path);
             textArea.append("\n");
             
             textArea.append(path);
            // textArea.append("\n");
             f=new File(curdir+"/"+path);
                //               System.out.println(f.isDirectory());
              //                 textArea.append(f.isDirectory()+"");
                    }
                 }catch(Exception e){
                    // if any error occurs
                    e.printStackTrace();
                 }
             textArea.append("\n");
         }
         else if(com.equals("cd"))
         {
             File f=null;
             String paths[];
             try{
                 f=new File(curdir);
                 paths=f.list();
                 String direc;
                 direc=comm[comm.length-1];
                 for(String path:paths)
                 {
                 if(path.equals(direc))
                 {
                     curdir=curdir+"/"+direc;
                     System.out.println("available");
                     textArea.append("\n");
                     
                     textArea.append("Available");
                 }
                 
                 }
                 System.out.println("sadasd"+direc);
               //  textArea.append("\n");
                 
             //    textArea.append(direc);
             }
             catch(Exception e){
                    // if any error occurs
                    e.printStackTrace();
                 }
             textArea.append("\n");
             
         }
         else if (com.equals("cd.."))
    	 {
    		 String nwdir=new String();
    		 int j=0,i=curdir.length()-1;
    		 while(i>=0)
    		 {
    			 if(curdir.charAt(i)=='/')
    			 {
    				 
    				 break;
    			 }
    			 i--;
    		 }
    		 if(i==0)
    			 textArea.append("Invalid \n");
    		 else
    		 {nwdir=curdir.substring(0, i);
    		 curdir=nwdir;
    		 System.out.println(curdir);
   			 textArea.append("\n");
   			    		 }
    	 }
         
          
        	 else	  if(dir.equals("mkdir"))
        {
            String path=fstc[2];
            File f=new File(curdir+"/"+path);
            if(!f.exists())
            {
                f.mkdir();
                System.out.println("directory created");
                textArea.append("\n");
                
                textArea.append("Directory Created");
                textArea.append("\n");
                
            }
            else
            {
                System.out.println("directory already exists");
                textArea.append("\n");
                
                textArea.append("Directory Already Exists");
                textArea.append("\n");
                
            }
            System.out.println("path is "+f.getPath());
            textArea.append("path is "+f.getPath());
            textArea.append("\n");
            
            System.out.println(f.isDirectory());
       //     textArea.append(f.isDirectory()+"");
        //    textArea.append("\n");
            
        }
        else if(dir.equals("rndir"))
        {
            String path=fstc[2];
            String source[]=path.split("\\ ");
               //System.out.println(source[0]+" hell "+source[1]);
           //    textArea.append(source[0]+" hell "+source[1]);
               File f=new File(curdir+"/"+fstc[2]);
               File z=new File(curdir+"/"+fstc[3]);
               f.renameTo(z);
               textArea.append("\n");
               textArea.append(fstc[2]+" renamed to "+fstc[3]);
               
               textArea.append("\n");
               
        }
        else if(dir.equals("rmdir"))
        {
            String path=fstc[2];
            File f=new File(curdir+"/"+path);
            if(f.exists())
            {      f.delete();
            textArea.append("\nDeleted\n");
            
            }else
            {   System.out.println("Doesn't exists");
textArea.append("\nDoesn't exists\n");
            }
        }
        else if(dir.equals("vim"))
        {texteditor0 te=new texteditor0();
        
            String path=fstc[2];
            File f=new File(curdir+"/"+path);
            try {
               if(f.createNewFile())
               {   //System.out.println("success");
textArea.append("\nSuccess\n");
te.textedit(" ",path);

               }else
                {
                    System.out.println("output the content");
                    textArea.append("\nContent Output\n");
                   String data=new String();
                  
                    br = new BufferedReader(new FileReader(curdir+"/"+path));
                       for (String line; (line = br.readLine()) != null;) {
                           System.out.println(line);
                           textArea.append(line+"\n");
                        data+=line+"\n";
                        
                       }
                       te.textedit(data,path);
                                
                }
           } catch (IOException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
           }
        }
        else if(dir.equals("diskscheduling"))
        {
        MainApp mp=new MainApp();
        try {
			mp.DiskScheduling(null);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        textArea.append("\n");
         }
        else if(dir.equals("diskmanagment"))
        {
        framepage fp=new framepage();
    		fp.pagefault(null);
	
        textArea.append("\n");
         }
        else
        {
        	textArea.append("\nInvalid Command\n");
            	
        }
        
         
         
        
         textArea.append("->"+curdir+" ");
            }
        });     

       // contentPane.add(textArea, BorderLayout.CENTER);
        contentPane.add(button, BorderLayout.PAGE_END);
button.setVisible(false);
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * @wbp.parser.entryPoint
     */
    public  void cmd(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                new testcmdd().displayGUI();
            }
        };
        EventQueue.invokeLater(r);
    }
}