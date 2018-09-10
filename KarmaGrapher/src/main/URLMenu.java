package main;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import capture.StatReader;

public class URLMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	StatReader kr = new StatReader();
	
	public URLMenu() {

		Color bg = new Color(100, 100, 100);
		
		JPanel panel 	= new JPanel();
		JTextField url 	= new JTextField("URL");
		JButton go		= new JButton("GO");
		
		ActionListener gol = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
			
		};
		
		
		this.setSize(500, 100);
		this.setLocationRelativeTo(null);
		
		this.add(panel);
		panel.setLayout(null);
		panel.setBackground(bg);
		
		panel.add(url);
		url.setBounds(10, 20, 400, 25);
		url.setBorder(null);
		url.setBackground(Color.white);
		
		panel.add(go);
		go.setBounds(410, 20, 60, 25);
		go.setBorder(null);
		
		
		
		this.setDefaultCloseOperation(3);
		this.setVisible(true);
		
	}
	
	

}
