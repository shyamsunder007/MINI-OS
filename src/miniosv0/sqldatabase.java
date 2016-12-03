package miniosv0;
import java.sql.*;
import javax.swing.*;
public class sqldatabase {
	Connection conn=null;
	public static Connection dbConnector()
	{	
      try{
    	  Class.forName("org.sqlite.JDBC");
    	  Connection conn=DriverManager.getConnection("jdbc:sqlite:C:\\mini os\\userid.sqlite");
          JOptionPane.showMessageDialog(null,"Connection sucessfull");
    	  return conn;
         }catch(Exception e)
          {
        	 JOptionPane.showMessageDialog(null,e);
        	 return null;
          }
    }
}