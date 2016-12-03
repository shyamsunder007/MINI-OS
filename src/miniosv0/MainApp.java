package miniosv0;

import java.awt.Color;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainApp {
	public  void DiskScheduling(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {


		UIManager.put("nimbusBase", new Color(225, 100, 255));
		UIManager.put("nimbusBlueGrey", new Color(200, 200, 200));
		UIManager.put("control", new Color(255,255,255));
		UIManager
				.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		new MainFrame();
	}
}