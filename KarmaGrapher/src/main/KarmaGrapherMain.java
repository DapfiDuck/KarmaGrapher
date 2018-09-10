package main;

import java.io.IOException;

import javax.swing.JOptionPane;

import capture.CaptureMenu;
import capture.StatReader;

public class KarmaGrapherMain {

	public static void main(String[] args) throws IOException {
		
//		URLMenu u = new URLMenu();
		
		StatReader sr 	= new StatReader();
		
		String url	= JOptionPane.showInputDialog("URL:");
		int time 	= Integer.parseInt(JOptionPane.showInputDialog("Time Between Requests (seconds)"));
		int c		= Integer.parseInt(JOptionPane.showInputDialog("Number of packets"));
		
		CaptureMenu cm	= new CaptureMenu(url, time*1000, sr);
		
		cm.capture(c);
		
	}

}
